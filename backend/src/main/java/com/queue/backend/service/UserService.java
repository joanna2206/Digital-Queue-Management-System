package com.queue.backend.service;
import com.queue.backend.dto.RegisterRequest;
public interface UserService {
  void registerUser(RegisterRequest request);
}
