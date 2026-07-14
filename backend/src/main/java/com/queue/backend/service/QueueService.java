package com.queue.backend.service;

import java.util.List;

import com.queue.backend.dto.queue.DashboardResponse;
import com.queue.backend.dto.queue.QueueHistoryResponse;
import com.queue.backend.dto.queue.QueueRequest;
import com.queue.backend.dto.queue.QueueResponse;
import com.queue.backend.dto.queue.QueueStatusResponse;
import com.queue.backend.dto.queue.QueueUpdateResponse;

public interface QueueService {

    QueueResponse createQueue(QueueRequest request);

    List<QueueStatusResponse> getWaitingQueues();

    DashboardResponse getDashboard();

    QueueUpdateResponse callNextQueue(Long id);

    QueueUpdateResponse completeQueue(Long id);

    QueueUpdateResponse cancelQueue(Long id);

    List<QueueHistoryResponse> getQueueHistory();

}