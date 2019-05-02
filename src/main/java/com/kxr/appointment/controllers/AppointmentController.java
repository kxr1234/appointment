package com.kxr.appointment.controllers;

import java.util.List;

import com.kxr.appointment.entities.Appointment;
import com.kxr.appointment.repo.AppointmentRepository;
import com.kxr.appointment.service.AppointmentService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentRepository userRepository, AppointmentService appointmentService ) {
        this.appointmentRepository = userRepository;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/users")
    public List<Appointment> getUsers() {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    @GetMapping("/users/{code}")
    Appointment getUserByCode(@PathVariable final String code) {
        return this.appointmentService.findByCode(code);
    }

    @PostMapping("/users")
    Appointment addUser(@RequestBody Appointment user) {
      return  this.appointmentService.create(user);
    }

    
}