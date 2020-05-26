import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import {UserModel} from '../model/UserModel';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  formLogin = new FormGroup({
    email: new FormControl('', [
      Validators.required,
      Validators.email
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(6)
    ])

  });

  constructor() { }

  ngOnInit(): void {

  }

  get email(){
    return this.formLogin.get('email');
  }
  get password() {
    return this.formLogin.get('password');
  }

  onSubmit() { alert(JSON.stringify(this.formLogin.value));
   }
}



