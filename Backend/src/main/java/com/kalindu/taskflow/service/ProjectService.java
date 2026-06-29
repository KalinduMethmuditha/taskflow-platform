package com.kalindu.taskflow.service;

import com.kalindu.taskflow.dto.ProjectRequestDTO;
import com.kalindu.taskflow.dto.ProjectResponseDTO;

import java.util.List;

public interface ProjectService {

    ProjectResponseDTO createProject(ProjectRequestDTO request);

    List<ProjectResponseDTO> getAllProjects();

    ProjectResponseDTO getProjectById(Long id);

    ProjectResponseDTO updateProject(Long id, ProjectRequestDTO request);

    void deleteProject(Long id);
}