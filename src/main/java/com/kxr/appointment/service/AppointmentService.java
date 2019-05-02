package com.kxr.appointment.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.kxr.appointment.entities.Appointment;

@Validated
public interface AppointmentService {

    Appointment create(@NotNull(message = "The appointment cannot be null") @Valid Appointment user);
    Appointment findByCode(@NotNull(message = "The code is invalid") @Valid String code);
}