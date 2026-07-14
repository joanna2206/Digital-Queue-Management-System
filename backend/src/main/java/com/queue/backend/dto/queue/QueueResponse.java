package com.queue.backend.dto.queue;

import com.queue.backend.enums.QueueStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QueueResponse {

    private String tokenNumber;
    private String department;
    private QueueStatus status;
    private Integer estimatedWaitTime;

}