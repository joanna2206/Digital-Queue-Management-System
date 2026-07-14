package com.queue.backend.service;

import com.queue.backend.dto.appointment.AppointmentRequest;
import com.queue.backend.dto.appointment.AppointmentResponse;

public interface AppointmentService {

    AppointmentResponse bookAppointment(AppointmentRequest request);

}