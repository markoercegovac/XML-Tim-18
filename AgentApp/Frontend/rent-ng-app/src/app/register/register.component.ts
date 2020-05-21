import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styles: [
  ]
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onSignIn() {
    console.log('go to sign in');
    this.router.navigate(['/sign-in']);
  }

  onRegister() {
    console.log('registaring');
    //TODO: http for registration
  }
}
