import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {UserRegister} from '../model/UserRegister';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styles: [
  ]
})
export class RegisterComponent implements OnInit {

  user: UserRegister = {
    name: '',
    surname: '',
    password: '',
    email: '',
    role: ''
  }

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
