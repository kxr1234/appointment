import { Component, OnInit } from '@angular/core';
import { Appointment } from '../models/appointment.model';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-retrieve',
  templateUrl: './retrieve.component.html',
  styleUrls: ['./retrieve.component.css']
})
export class RetrieveComponent implements OnInit {

  constructor(private userService: UserService , private router: Router) { }

  appointment: Appointment;
  code: string;

  ngOnInit() {
    this.code = '';
    this.appointment = new Appointment();
  }

  onSubmit() {
    this.userService.findAppointment(this.code).subscribe(result =>  this.gotoUserList(result));
  }

  gotoUserList(resApp: Appointment[]) {
    this.appointment = resApp[0];
}

}
