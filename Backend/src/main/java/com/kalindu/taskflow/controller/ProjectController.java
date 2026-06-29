package com.kalindu.taskflow.controller;

import com.kalindu.taskflow.dto.ProjectRequestDTO;
import com.kalindu.taskflow.dto.ProjectResponseDTO;
import com.kalindu.taskflow.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Create Project
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping
    public ProjectResponseDTO createProject(
            @Valid @RequestBody ProjectRequestDTO request) {

        return projectService.createProject(request);
    }

    // Get All Projects
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','DEVELOPER')")
    @GetMapping
    public List<ProjectResponseDTO> getAllProjects() {

        return projectService.getAllProjects();
    }

    // Get Project By Id
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','DEVELOPER')")
    @GetMapping("/{id}")
    public ProjectResponseDTO getProjectById(
            @PathVariable Long id) {

        return projectService.getProjectById(id);
    }

    // Update Project
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PutMapping("/{id}")
    public ProjectResponseDTO updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequestDTO request) {

        return projectService.updateProject(id, request);
    }

    // Delete Project
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteProject(
            @PathVariable Long id) {

        projectService.deleteProject(id);
    }
}
