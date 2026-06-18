package com.kalindu.taskflow.controller;

import com.kalindu.taskflow.dto.ProjectResponseDTO;
import com.kalindu.taskflow.dto.ProjectRequestDTO;
import com.kalindu.taskflow.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*")



@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ProjectResponseDTO createProject(
            @RequestBody ProjectRequestDTO request) {

        return projectService.createProject(request);
    }

    @GetMapping
    public List<ProjectResponseDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponseDTO getProjectById(
            @PathVariable Long id) {

        return projectService.getProjectById(id);
    }
}