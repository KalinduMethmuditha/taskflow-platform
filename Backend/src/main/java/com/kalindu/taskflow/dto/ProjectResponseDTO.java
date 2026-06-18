package com.kalindu.taskflow.dto;

import com.kalindu.taskflow.enums.ProjectStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponseDTO {

    private Long id;

    private String name;

    private String description;

    private ProjectStatus status;

    private Long ownerId;

    private String ownerName;
}