package com.queue.backend.service.impl;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.queue.backend.dto.RegisterRequest;
import com.queue.backend.entity.User;
import com.queue.backend.exception.ResourceAlreadyExistsException;
import com.queue.backend.repository.UserRepository;
import com.queue.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already exists.");
        }

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new ResourceAlreadyExistsException("Phone number already exists.");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(request.getRole())
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }
}