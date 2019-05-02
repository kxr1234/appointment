package com.kxr.appointment.repo;
import com.kxr.appointment.entities.AppointmentTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface AppointmentTimeRepository extends CrudRepository<AppointmentTime, Long>{}