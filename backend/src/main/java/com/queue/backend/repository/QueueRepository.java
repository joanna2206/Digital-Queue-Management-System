package com.queue.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.queue.backend.entity.Queue;
import com.queue.backend.enums.QueueStatus;

public interface QueueRepository extends JpaRepository<Queue, Long> {

    List<Queue> findByStatus(QueueStatus status);

    long countByStatus(QueueStatus status);

}