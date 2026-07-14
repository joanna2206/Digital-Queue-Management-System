package com.queue.backend.dto.queue;

import com.queue.backend.enums.QueueStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QueueStatusResponse {

    private String tokenNumber;
    private QueueStatus status;
    private Integer estimatedWaitTime;
}