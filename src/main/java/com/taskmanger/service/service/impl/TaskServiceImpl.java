package com.taskmanger.service.service.impl;

import com.taskmanger.service.dto.TaskDto;
import com.taskmanger.service.dto.UpdateTaskDto;
import com.taskmanger.service.entity.Task;
import com.taskmanger.service.exception.ResourceAlreadyExistsException;
import com.taskmanger.service.exception.ResourceNotFoundException;
import com.taskmanger.service.mapper.TaskMapper;
import com.taskmanger.service.repository.TaskRepository;
import com.taskmanger.service.service.ITaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements ITaskService {

    private TaskRepository taskRepository;
    private static final String DEFAULT_STATUS = "pending";

    @Override
    public void createTask(TaskDto taskDto) {
        String title = taskDto.getTitle();
        String author = taskDto.getAuthor();
        if (title != null && author != null && taskRepository.existsByTitleAndAuthor(title, author)) {
            throw new ResourceAlreadyExistsException("Task", "title+author", title + " / " + author);
        }

        Task newTask = TaskMapper.mapToEntity(taskDto, new Task());
        newTask.setId(UUID.randomUUID().toString());
        if (taskDto.getStatus() == null) {
            newTask.setStatus(DEFAULT_STATUS);
        }
        taskRepository.save(newTask);
    }

    @Override
    public void updateTask(String id, UpdateTaskDto taskDto) {
        Task existing = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));

        if (taskDto.getStatus() != null) {
            existing.setStatus(taskDto.getStatus());
        }
        if (taskDto.getProject() != null) {
            existing.setProject(taskDto.getProject());
        }
        if (taskDto.getTitle() != null) {
            existing.setTitle(taskDto.getTitle());
        }
        if (taskDto.getAuthor() != null) {
            existing.setAuthor(taskDto.getAuthor());
        }
        if (taskDto.getDescription() != null) {
            existing.setDescription(taskDto.getDescription());
        }
        taskRepository.save(existing);
    }

    @Override
    public TaskDto fetchTask(String id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "id", id));
        return TaskMapper.mapToDto(new TaskDto(), task);
    }

    @Override
    public List<TaskDto> listAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(task -> TaskMapper.mapToDto(new TaskDto(), task)).toList();
    }
}
