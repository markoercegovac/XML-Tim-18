import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent {

  constructor(
    private router: Router
  ) {}

  onAgent() {
    this.router.navigate(['home','register','agent']);
  }

  onUser() {
    this.router.navigate(['home','register','user']);
  }
}
