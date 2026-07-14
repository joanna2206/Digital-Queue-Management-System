package com.queue.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.queue.backend.entity.Queue;

public interface QueueRepository extends JpaRepository<Queue, Long> {

}