import { Component, ViewChild } from '@angular/core';
import { AppointmentComponent } from './appointment/appointment.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private collapsed = true;
     title = 'angularclient';

  toggleCollapsed(): void {
    this.collapsed = !this.collapsed;
}

reset(){
  alert('reset');
}
}
