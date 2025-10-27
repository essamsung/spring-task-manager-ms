package com.taskmanger.service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    private String id;

    @NotEmpty(message = "Title must not be empty")
    private String title;

    @NotEmpty(message = "Author must not be empty")
    private String author;

    private String description;

    @Pattern(regexp = "^(pending|in-progress|completed)$", message = "Status must be 'pending', 'in-progress' or 'completed'")
    private String status;

    @NotEmpty(message = "Project must not be empty")
    private String project;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
