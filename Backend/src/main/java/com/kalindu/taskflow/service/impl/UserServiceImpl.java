package com.kalindu.taskflow.service.impl;

import com.kalindu.taskflow.dto.UserRequestDTO;
import com.kalindu.taskflow.dto.UserResponseDTO;
import com.kalindu.taskflow.entity.User;
import com.kalindu.taskflow.repository.UserRepository;
import com.kalindu.taskflow.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponseDTO.builder()
                .id(savedUser.getId())
                .fullName(savedUser.getFullName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }
    @Override
    public List<UserResponseDTO> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> UserResponseDTO.builder()
                        .id(user.getId())
                        .fullName(user.getFullName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("id"));

        return UserResponseDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO request) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("id"));

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        User updatedUser = userRepository.save(user);

        return UserResponseDTO.builder()
                .id(updatedUser.getId())
                .fullName(updatedUser.getFullName())
                .email(updatedUser.getEmail())
                .role(updatedUser.getRole())
                .build();
    }
    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("id"));

        userRepository.delete(user);
    }


}
