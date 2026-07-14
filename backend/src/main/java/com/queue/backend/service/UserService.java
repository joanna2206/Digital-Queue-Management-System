package com.queue.backend.service;

import com.queue.backend.dto.LoginRequest;
import com.queue.backend.dto.LoginResponse;
import com.queue.backend.dto.RegisterRequest;

public interface UserService {

    void registerUser(RegisterRequest request);

    LoginResponse loginUser(LoginRequest request);

}