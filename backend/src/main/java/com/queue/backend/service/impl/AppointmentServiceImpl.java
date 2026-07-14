package com.queue.backend.service.impl;

import org.springframework.stereotype.Service;

import com.queue.backend.dto.appointment.AppointmentRequest;
import com.queue.backend.dto.appointment.AppointmentResponse;
import com.queue.backend.entity.Appointment;
import com.queue.backend.enums.AppointmentStatus;
import com.queue.backend.repository.AppointmentRepository;
import com.queue.backend.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentResponse bookAppointment(AppointmentRequest request) {

        Appointment appointment = Appointment.builder()
                .appointmentDate(request.getAppointmentDate())
                .appointmentTime(request.getAppointmentTime())
                .department(request.getDepartment())
                .reason(request.getReason())
                .status(AppointmentStatus.PENDING)
                .build();

        appointment = appointmentRepository.save(appointment);

        return new AppointmentResponse(
                appointment.getId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getDepartment(),
                appointment.getReason(),
                appointment.getStatus()
        );
    }
}