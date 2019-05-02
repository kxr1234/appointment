import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppointmentComponent } from './appointment/appointment.component';
import { AppComponent } from './app.component';
import { RetrieveComponent } from './retrieve/retrieve.component';

const routes: Routes = [
  { path: 'home', component: AppComponent },
  { path: 'appointmentNew', component: AppointmentComponent },
  { path: 'appointmentRet', component: RetrieveComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
