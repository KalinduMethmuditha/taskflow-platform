package com.kalindu.taskflow.controller;

import com.kalindu.taskflow.dto.LoginRequestDTO;
import com.kalindu.taskflow.dto.LoginResponseDTO;
import com.kalindu.taskflow.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @Valid @RequestBody LoginRequestDTO request) {

        return authService.login(request);
    }
}