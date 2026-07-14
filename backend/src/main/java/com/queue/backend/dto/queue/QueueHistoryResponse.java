package com.queue.backend.dto.queue;

import java.time.LocalDateTime;

import com.queue.backend.enums.QueueStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QueueHistoryResponse {

    private Long id;
    private String tokenNumber;
    private String department;
    private QueueStatus status;
    private LocalDateTime createdAt;

}