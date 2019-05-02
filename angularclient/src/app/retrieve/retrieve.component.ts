import { Component, OnInit } from '@angular/core';
import { Appointment } from '../models/appointment.model';
import { Router } from '@angular/router';
import { AppointmentService } from '../service/appointment.service';

@Component({
  selector: 'app-retrieve',
  templateUrl: './retrieve.component.html',
  styleUrls: ['./retrieve.component.css']
})
export class RetrieveComponent implements OnInit {

  constructor(private appointmentService: AppointmentService , private router: Router) { }

  appointment: Appointment;
  code: string;

  ngOnInit() {
    this.code = '';
    this.appointment = new Appointment();
  }

  onSubmit() {
    this.appointmentService.findAppointment(this.code).subscribe(result =>  this.updateAppointment(result));
  }

  updateAppointment(resApp: Appointment[]) {
    this.appointment = resApp[0];
}

}
