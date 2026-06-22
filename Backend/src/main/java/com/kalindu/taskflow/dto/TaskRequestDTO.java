package com.kalindu.taskflow.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskRequestDTO {

    private String title;

    private String description;

    private Long projectId;

    private Long assignedUserId;
}