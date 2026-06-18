package com.kalindu.taskflow.service.impl;

import com.kalindu.taskflow.dto.ProjectRequestDTO;
import com.kalindu.taskflow.dto.ProjectResponseDTO;
import com.kalindu.taskflow.entity.Project;
import com.kalindu.taskflow.entity.User;
import com.kalindu.taskflow.enums.ProjectStatus;
import com.kalindu.taskflow.exception.ProjectNotFoundException;
import com.kalindu.taskflow.exception.UserNotFoundException;
import com.kalindu.taskflow.mapper.ProjectMapper;
import com.kalindu.taskflow.repository.ProjectRepository;
import com.kalindu.taskflow.repository.UserRepository;
import com.kalindu.taskflow.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository,
                              UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO request) {

        User owner = userRepository.findById(request.getOwnerId())
                .orElseThrow(() ->
                        new UserNotFoundException(request.getOwnerId()));

        Project project = Project.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(ProjectStatus.PLANNING)
                .owner(owner)
                .build();

        Project savedProject = projectRepository.save(project);

        return ProjectMapper.toResponseDTO(savedProject);
    }

    @Override
    public List<ProjectResponseDTO> getAllProjects() {

        return projectRepository.findAll()
                .stream()
                .map(ProjectMapper::toResponseDTO)
                .toList();
    }

    @Override
    public ProjectResponseDTO getProjectById(Long id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ProjectNotFoundException(id));

        return ProjectMapper.toResponseDTO(project);
    }
}