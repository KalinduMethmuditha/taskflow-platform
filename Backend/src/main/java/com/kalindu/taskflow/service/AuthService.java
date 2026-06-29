package com.kalindu.taskflow.service;

import com.kalindu.taskflow.dto.LoginRequestDTO;
import com.kalindu.taskflow.dto.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO request);

}