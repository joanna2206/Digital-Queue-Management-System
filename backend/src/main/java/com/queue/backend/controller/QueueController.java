package com.queue.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queue.backend.dto.queue.DashboardResponse;
import com.queue.backend.dto.queue.QueueRequest;
import com.queue.backend.dto.queue.QueueResponse;
import com.queue.backend.dto.queue.QueueStatusResponse;
import com.queue.backend.service.QueueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    private final QueueService queueService;

    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @PostMapping
    public ResponseEntity<QueueResponse> createQueue(
            @Valid @RequestBody QueueRequest request) {

        return new ResponseEntity<>(
                queueService.createQueue(request),
                HttpStatus.CREATED);
    }

    @GetMapping("/waiting")
    public List<QueueStatusResponse> getWaitingQueues() {
        return queueService.getWaitingQueues();
    }

    @GetMapping("/dashboard")
    public DashboardResponse getDashboard() {
        return queueService.getDashboard();
    }
}