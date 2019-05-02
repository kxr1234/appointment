import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Appointment } from '../models/appointment.model';
import { Observable } from 'rxjs';

@Injectable()
export class AppointmentService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(this.usersUrl);
  }

  public findAppointment(code: string): Observable<Appointment[]> {
    const options = code ?
   { params: new HttpParams().set('code', code) } : {};

    return this.http.get<Appointment[]>(this.usersUrl, options);
  }

  public save(user: Appointment) {
    return this.http.post<Appointment>(this.usersUrl, user);
  }
}
