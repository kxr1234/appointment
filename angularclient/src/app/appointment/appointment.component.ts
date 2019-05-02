import { Component, OnInit } from '@angular/core';
import { Appointment } from '../models/appointment.model';
import { AppointmentService } from '../service/appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  appointment: Appointment;

  constructor(private appointmentService: AppointmentService , private router: Router) {
    this.appointment = new Appointment();
   }

  ngOnInit() {
  }

  onSubmit() {
    this.appointmentService.save(this.appointment).subscribe(result => this.updateAppointment(result));
  }

  updateAppointment(resApp: Appointment) {
        this.appointment = resApp;
  }

}
