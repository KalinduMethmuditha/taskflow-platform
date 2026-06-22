package com.kalindu.taskflow.service;

import com.kalindu.taskflow.dto.TaskRequestDTO;
import com.kalindu.taskflow.dto.TaskResponseDTO;
import com.kalindu.taskflow.dto.TaskStatusUpdateDTO;

import java.util.List;

public interface TaskService {

    TaskResponseDTO createTask(TaskRequestDTO request);

    List<TaskResponseDTO> getAllTasks();

    TaskResponseDTO getTaskById(Long id);

    TaskResponseDTO updateTaskStatus(
            Long taskId,
            TaskStatusUpdateDTO request);
}