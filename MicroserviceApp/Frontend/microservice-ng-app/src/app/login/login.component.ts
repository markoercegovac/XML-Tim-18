import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup, NgForm } from '@angular/forms';
import { AuthService } from '../services/auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth: AuthService) { }

  ngOnInit(): void {
  }

  onLogin(form: NgForm) {

    let email = form.value.email;
    let password = form.value.password;

    console.log(email, password);
    this.auth.login(email, password);
  }
}
