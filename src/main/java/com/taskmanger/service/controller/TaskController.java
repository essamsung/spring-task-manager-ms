package com.taskmanger.service.controller;


import com.taskmanger.service.dto.ResponseDto;
import com.taskmanger.service.dto.TaskDto;
import com.taskmanger.service.dto.UpdateTaskDto;
import com.taskmanger.service.service.ITaskService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tasks", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    ITaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createTask(@Valid @RequestBody TaskDto taskDto) {
        taskService.createTask(taskDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "Task created successfully"));
    }

    @GetMapping("/fetch")
    public ResponseEntity<TaskDto> fetchTask(@RequestParam
                                             String id) {
        TaskDto taskDto = taskService.fetchTask(id);
        return ResponseEntity.status(HttpStatus.OK).body(taskDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TaskDto>> listAllTasks() {
        List<TaskDto> taskDto = taskService.listAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(taskDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateTask(
            @PathVariable String id,
            @Valid @RequestBody UpdateTaskDto taskDto) {
        taskService.updateTask(id, taskDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto("200", "Task updated successfully"));

    }

}
