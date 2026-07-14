package com.queue.backend.dto.queue;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QueueRequest {

    @NotBlank(message = "Department is required")
    private String department;

}