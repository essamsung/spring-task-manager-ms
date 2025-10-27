package com.taskmanger.service.mapper;

import com.taskmanger.service.dto.TaskDto;
import com.taskmanger.service.entity.Task;

public class TaskMapper {
    public static Task mapToEntity(TaskDto dto, Task entity) {
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setProject(dto.getProject());
        return entity;
    }

    public static TaskDto mapToDto(TaskDto dto, Task entity) {
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setAuthor(entity.getAuthor());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setProject(entity.getProject());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
