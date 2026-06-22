package com.kalindu.taskflow.dto;

import com.kalindu.taskflow.enums.TaskStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponseDTO {

    private Long id;

    private String title;

    private String description;

    private TaskStatus status;

    private Long projectId;
    private String projectName;

    private Long assignedUserId;
    private String assignedUserName;
}