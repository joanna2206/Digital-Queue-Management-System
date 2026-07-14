package com.queue.backend.dto.queue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {

    private long totalQueues;
    private long waitingQueues;
    private long completedQueues;
}