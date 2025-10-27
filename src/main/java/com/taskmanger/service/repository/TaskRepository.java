package com.taskmanger.service.repository;

import com.taskmanger.service.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    boolean existsByTitleAndAuthor(String title, String author);
}
