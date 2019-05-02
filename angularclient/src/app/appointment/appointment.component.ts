import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Appointment } from '../models/appointment.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  appointment: Appointment;

  constructor(private userService: UserService , private router: Router) {
    this.appointment = new Appointment();
   }

  ngOnInit() {
  }

  onSubmit() {
    this.userService.save(this.appointment).subscribe(result => this.gotoUserList(result));
  }

  gotoUserList(resApp: Appointment) {
        this.appointment = resApp;
  }

}
