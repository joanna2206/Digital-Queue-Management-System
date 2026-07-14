package com.queue.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.queue.backend.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}