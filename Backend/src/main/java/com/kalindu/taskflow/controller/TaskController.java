package com.kalindu.taskflow.controller;


import com.kalindu.taskflow.dto.TaskRequestDTO;
import com.kalindu.taskflow.dto.TaskResponseDTO;
import com.kalindu.taskflow.dto.TaskStatusUpdateDTO;
import com.kalindu.taskflow.service.TaskService;
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

    @PostMapping
    public TaskResponseDTO createTask(
            @RequestBody TaskRequestDTO request) {

        return taskService.createTask(request);
    }

    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {

        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(
            @PathVariable Long id) {

        return taskService.getTaskById(id);
    }
    @PatchMapping("/{id}/status")
    public TaskResponseDTO updateTaskStatus(
            @PathVariable Long id,
            @RequestBody TaskStatusUpdateDTO request) {

        return taskService.updateTaskStatus(id, request);
    }
}