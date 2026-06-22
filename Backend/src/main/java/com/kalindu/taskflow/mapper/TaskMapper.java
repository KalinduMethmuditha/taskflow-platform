package com.kalindu.taskflow.mapper;

import com.kalindu.taskflow.dto.TaskResponseDTO;
import com.kalindu.taskflow.entity.Task;

public class TaskMapper {

    public static TaskResponseDTO toResponseDTO(
            Task task) {

        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())

                .projectId(task.getProject().getId())
                .projectName(task.getProject().getName())

                .assignedUserId(
                        task.getAssignedUser() != null
                                ? task.getAssignedUser().getId()
                                : null)

                .assignedUserName(
                        task.getAssignedUser() != null
                                ? task.getAssignedUser().getFullName()
                                : null)

                .build();
    }
}