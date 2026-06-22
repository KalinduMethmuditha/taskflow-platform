package com.kalindu.taskflow.repository;

import com.kalindu.taskflow.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository
        extends JpaRepository<Task, Long> {
}