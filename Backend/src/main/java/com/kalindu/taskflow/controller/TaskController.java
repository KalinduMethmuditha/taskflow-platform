package com.kalindu.taskflow.controller;


import com.kalindu.taskflow.dto.TaskRequestDTO;
import com.kalindu.taskflow.dto.TaskResponseDTO;
import com.kalindu.taskflow.dto.TaskStatusUpdateDTO;
import com.kalindu.taskflow.service.TaskService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(
            TaskService taskService) {
        this.taskService = taskService;
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping
    public TaskResponseDTO createTask(
            @RequestBody TaskRequestDTO request) {

        return taskService.createTask(request);
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','DEVELOPER')")
    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {

        return taskService.getAllTasks();
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','DEVELOPER')")
    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(
            @PathVariable Long id) {

        return taskService.getTaskById(id);
    }
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','DEVELOPER')")
    @PatchMapping("/{id}/status")
    public TaskResponseDTO updateTaskStatus(
            @PathVariable Long id,
            @RequestBody TaskStatusUpdateDTO request) {

        return taskService.updateTaskStatus(id, request);
    }
}