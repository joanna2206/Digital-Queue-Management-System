package com.queue.backend.service;

import com.queue.backend.dto.auth.LoginRequest;
import com.queue.backend.dto.auth.LoginResponse;
import com.queue.backend.dto.auth.RegisterRequest;

public interface UserService {

    void registerUser(RegisterRequest request);

    LoginResponse loginUser(LoginRequest request);

}