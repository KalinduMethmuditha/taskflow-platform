package com.kalindu.taskflow.mapper;

import com.kalindu.taskflow.dto.ProjectResponseDTO;
import com.kalindu.taskflow.entity.Project;

public class ProjectMapper {

    public static ProjectResponseDTO toResponseDTO(Project project) {

        return ProjectResponseDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .status(project.getStatus())
                .ownerId(project.getOwner().getId())
                .ownerName(project.getOwner().getFullName())
                .build();
    }
}