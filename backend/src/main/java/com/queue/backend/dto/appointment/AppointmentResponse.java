package com.queue.backend.dto.appointment;

import java.time.LocalDate;
import java.time.LocalTime;

import com.queue.backend.enums.AppointmentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppointmentResponse {

    private Long id;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String department;
    private String reason;
    private AppointmentStatus status;
}