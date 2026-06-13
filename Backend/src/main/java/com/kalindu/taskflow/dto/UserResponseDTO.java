package com.kalindu.taskflow.dto;

import com.kalindu.taskflow.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDTO {

    private Long id;

    private String fullName;

    private String email;

    private Role role;
}