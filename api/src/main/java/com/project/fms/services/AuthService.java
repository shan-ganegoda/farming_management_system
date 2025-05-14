package com.project.fms.services;

import com.project.fms.dtos.AuthResponse;
import com.project.fms.dtos.LoginRequest;
import com.project.fms.dtos.RegisterRequest;

public interface AuthService {
    AuthResponse login(LoginRequest request);

    AuthResponse register(RegisterRequest request);

    AuthResponse getRefreshToken(String value);
}
