package com.kxr.appointment.controllers;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

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
        List<Appointment> results = (List<Appointment>) appointmentRepository.findAll(); 
        Appointment result =  results.stream().filter(x -> code.equals(x.getCode())).findAny().orElse(null);
        return result;
    }

    @PostMapping("/users")
    Appointment addUser(@RequestBody Appointment user) {
      user.setCode(generatedCode());
      Appointment appointment =   this.appointmentService.create(user);
      return appointment;
    }

    String generatedCode(){
        char[] text = new char[4];
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 4; i++) {
            text[i] = characters.charAt(new Random().nextInt(characters.length()));
        }
        return new String(text);
    
    }
}