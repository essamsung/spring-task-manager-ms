package com.taskmanger.service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "task",
        uniqueConstraints = @UniqueConstraint(name = "uc_task_title_author", columnNames = {"title", "author"})
)
public class Task extends BaseEntity {

    @Id
    private String id;

    private String title;

    private String author;

    private String description;

    // "pending" (default), "in-progress", or "completed"
    private String status;

    private String project;
}

