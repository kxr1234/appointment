package com.kxr.appointment.repo;

import com.kxr.appointment.entities.Appointment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long>{}