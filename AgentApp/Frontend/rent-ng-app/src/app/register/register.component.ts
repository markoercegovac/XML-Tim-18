import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {UserRegister} from '../model/UserRegister';
import {HttpClient} from "@angular/common/http";

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

  constructor(private router: Router , public http : HttpClient) { }

  ngOnInit(): void {
  }

  onSignIn() {
    console.log('go to sign in');
    this.router.navigate(['/sign-in']);
  }

  onRegister() {

    this.http.post('http://localhost:9090/register', this.user).subscribe(
      res => {
        alert("Zahtev za registraciju je poslat.Dalje informacije o prihvatanja bice poslate na mail.");
      },
      error => {
        alert("Nesto je krenulo pogresno ");
      }
    );

  }
}
