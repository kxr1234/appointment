package com.kxr.appointment.service;

import java.util.List;
import java.util.Random;

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
        user.setCode(generatedCode());
        return this.appointmentRepository.save(user);
    }

    @Override
    public Appointment findByCode(String code) {
        List<Appointment> results = (List<Appointment>) appointmentRepository.findAll(); 
        Appointment result =  results.stream().filter(x -> code.equals(x.getCode())).findAny().orElse(null);
        return result;
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