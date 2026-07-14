package com.queue.backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.queue.backend.dto.queue.DashboardResponse;
import com.queue.backend.dto.queue.QueueRequest;
import com.queue.backend.dto.queue.QueueResponse;
import com.queue.backend.dto.queue.QueueStatusResponse;
import com.queue.backend.entity.Queue;
import com.queue.backend.enums.QueueStatus;
import com.queue.backend.repository.QueueRepository;
import com.queue.backend.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService {

    private final QueueRepository queueRepository;

    public QueueServiceImpl(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    @Override
    public QueueResponse createQueue(QueueRequest request) {

        String tokenNumber = "A-" + String.format("%03d", queueRepository.count() + 1);

        Queue queue = Queue.builder()
                .tokenNumber(tokenNumber)
                .department(request.getDepartment())
                .status(QueueStatus.WAITING)
                .estimatedWaitTime(15)
                .createdAt(LocalDateTime.now())
                .build();

        queueRepository.save(queue);

        return new QueueResponse(
                queue.getTokenNumber(),
                queue.getDepartment(),
                queue.getStatus(),
                queue.getEstimatedWaitTime()
        );
    }

    @Override
    public List<QueueStatusResponse> getWaitingQueues() {

        return queueRepository.findByStatus(QueueStatus.WAITING)
                .stream()
                .map(queue -> new QueueStatusResponse(
                        queue.getTokenNumber(),
                        queue.getStatus(),
                        queue.getEstimatedWaitTime()))
                .toList();
    }

    @Override
    public DashboardResponse getDashboard() {

        long total = queueRepository.count();
        long waiting = queueRepository.countByStatus(QueueStatus.WAITING);
        long completed = queueRepository.countByStatus(QueueStatus.COMPLETED);

        return new DashboardResponse(
                total,
                waiting,
                completed
        );
    }
}