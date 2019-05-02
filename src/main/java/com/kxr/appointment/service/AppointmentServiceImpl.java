package com.kxr.appointment.service;

import com.kxr.appointment.entities.Appointment;
import com.kxr.appointment.repo.AppointmentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment create(Appointment user) {
        return this.appointmentRepository.save(user);
    }

}