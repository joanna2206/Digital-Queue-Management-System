package com.queue.backend.service;

import com.queue.backend.dto.queue.QueueRequest;
import com.queue.backend.dto.queue.QueueResponse;

public interface QueueService {

    QueueResponse createQueue(QueueRequest request);

}