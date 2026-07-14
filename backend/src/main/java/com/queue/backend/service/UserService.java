package com.queue.backend.service;

import com.queue.backend.dto.auth.LoginRequest;
import com.queue.backend.dto.auth.LoginResponse;
import com.queue.backend.dto.auth.RegisterRequest;
import com.queue.backend.dto.user.ChangePasswordRequest;
import com.queue.backend.dto.user.UpdateProfileRequest;
import com.queue.backend.dto.user.UserProfileResponse;

public interface UserService {

    void registerUser(RegisterRequest request);

    LoginResponse loginUser(LoginRequest request);

    UserProfileResponse getProfile(String email);

    UserProfileResponse updateProfile(
            String email,
            UpdateProfileRequest request);

    void changePassword(
            String email,
            ChangePasswordRequest request);

}