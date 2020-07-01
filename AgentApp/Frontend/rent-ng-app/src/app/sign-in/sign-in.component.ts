import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {User} from '../model/User';
import {AuthService} from '../service/AuthService';
@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html'
})
export class SignInComponent implements OnInit {

  user: User = {
    username: '',
    password: ''
  };

  constructor(private router: Router, private auth: AuthService) { }

  ngOnInit(): void {
  }

  onSignIn() {

    console.log(this.user.username);
    console.log(this.user.password);
    this.auth.login(this.user.username, this.user.password);


    }




}
