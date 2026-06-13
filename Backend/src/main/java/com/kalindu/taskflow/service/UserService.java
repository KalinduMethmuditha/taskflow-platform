package com.kalindu.taskflow.service;

import com.kalindu.taskflow.dto.UserRequestDTO;
import com.kalindu.taskflow.dto.UserResponseDTO;
import com.kalindu.taskflow.entity.User;

import java.util.List;
public interface UserService
{
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);
}


