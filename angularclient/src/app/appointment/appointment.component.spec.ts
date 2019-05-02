import { async, ComponentFixture, TestBed, flushMicrotasks } from '@angular/core/testing';

import { AppointmentComponent } from './appointment.component';
import { Appointment } from '../models/appointment.model';
import { compileNgModule } from '@angular/compiler';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { AppComponent } from '../app.component';
import { RetrieveComponent } from '../retrieve/retrieve.component';
import { AppointmentService } from '../service/appointment.service';


describe('AppointmentComponent', () => {
  let component: AppointmentComponent;
  let fixture: ComponentFixture<AppointmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppointmentComponent, AppComponent, RetrieveComponent ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
      ],
      providers: [AppointmentService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppointmentComponent);
    component = fixture.componentInstance;
    component.appointment.appDate = new Date('2019-05-05');
    component.appointment.dob = new Date('1990-05-05');
    component.appointment.firstName = 'Kaushik';
    component.appointment.lastName = 'Rajan';
    component.appointment.time = '03:00PM';
    component.appointment.code = '';
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
