package com.taskmanger.service.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateTaskDto {

    private String title;

    private String author;

    private String description;

    @Pattern(regexp = "^(pending|in-progress|completed)$", message = "Status must be 'pending', 'in-progress' or 'completed'")
    private String status;

    private String project;
}
