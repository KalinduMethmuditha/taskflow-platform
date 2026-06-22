package com.kalindu.taskflow.service.impl;

import com.kalindu.taskflow.dto.TaskRequestDTO;
import com.kalindu.taskflow.dto.TaskResponseDTO;
import com.kalindu.taskflow.dto.TaskStatusUpdateDTO;
import com.kalindu.taskflow.entity.Project;
import com.kalindu.taskflow.entity.Task;
import com.kalindu.taskflow.entity.User;
import com.kalindu.taskflow.enums.TaskStatus;
import com.kalindu.taskflow.exception.ProjectNotFoundException;
import com.kalindu.taskflow.exception.TaskNotFoundException;
import com.kalindu.taskflow.exception.UserNotFoundException;
import com.kalindu.taskflow.mapper.TaskMapper;
import com.kalindu.taskflow.repository.ProjectRepository;
import com.kalindu.taskflow.repository.TaskRepository;
import com.kalindu.taskflow.repository.UserRepository;
import com.kalindu.taskflow.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository,
                           ProjectRepository projectRepository,
                           UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO request) {

        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() ->
                        new ProjectNotFoundException(request.getProjectId()));

        User assignedUser = userRepository.findById(request.getAssignedUserId())
                .orElseThrow(() ->
                        new UserNotFoundException(request.getAssignedUserId()));

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(TaskStatus.TODO)
                .project(project)
                .assignedUser(assignedUser)
                .build();

        Task savedTask = taskRepository.save(task);

        return TaskMapper.toResponseDTO(savedTask);
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {

        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toResponseDTO)
                .toList();
    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException(id));

        return TaskMapper.toResponseDTO(task);
    }

    @Override
    public TaskResponseDTO updateTaskStatus(
            Long taskId,
            TaskStatusUpdateDTO request) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new TaskNotFoundException(taskId));

        task.setStatus(request.getStatus());

        Task updatedTask = taskRepository.save(task);

        return TaskMapper.toResponseDTO(updatedTask);
    }
}