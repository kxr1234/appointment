package com.kxr.appointment.appointment;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.kxr.appointment.entities.Appointment;
import com.kxr.appointment.service.AppointmentService;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentApplicationTests {

	@Autowired  AppointmentService appService;

	@Test
	public void contextLoads() {
		Assertions
          .assertThat(appService)
          .isNotNull();
	}

	@Test
	public void getAppointmentByCode() {
		String code = "ABCD";
		Appointment appByCode = appService.findByCode(code);
		Assertions.assertThat(appByCode).isNull();
	}

	@Test
	public void postNewAppointment() {
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Appointment newApp = new Appointment("Kaushik","Rajan",date,date,"3:00 PM");
		Appointment appFromNewApp = appService.create(newApp);
		Assertions.assertThat(appFromNewApp).isNotNull();
		String code = appFromNewApp.getCode();
		Appointment appByCode = appService.findByCode(code);
		Assertions.assertThat(appByCode).isNotNull();

	}

}
