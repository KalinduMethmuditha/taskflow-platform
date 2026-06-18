package com.kalindu.taskflow.mapper;

import com.kalindu.taskflow.dto.UserResponseDTO;
import com.kalindu.taskflow.entity.User;

public class UserMapper {

    public static UserResponseDTO toResponseDTO(User user) {

        return UserResponseDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}