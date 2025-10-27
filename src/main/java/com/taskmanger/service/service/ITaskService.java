package com.taskmanger.service.service;

import com.taskmanger.service.dto.TaskDto;
import com.taskmanger.service.dto.UpdateTaskDto;

import java.util.List;

public interface ITaskService {
    void createTask(TaskDto taskDto);

    void updateTask(String id, UpdateTaskDto taskDto);

    TaskDto fetchTask(String id);

    List<TaskDto> listAllTasks();
}
