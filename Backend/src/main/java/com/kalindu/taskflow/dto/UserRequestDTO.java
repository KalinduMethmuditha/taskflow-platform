package com.kalindu.taskflow.dto;


import com.kalindu.taskflow.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRequestDTO {
    @NotBlank(message="Full name is requires")
    private String fullName;

    @Email(message = "Invalid Email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "password is required")
    private String password;

    private Role role;
}
