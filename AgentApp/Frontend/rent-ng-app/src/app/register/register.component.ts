import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {UserRegister} from '../model/UserRegister';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styles: [
  ]
})
export class RegisterComponent implements OnInit {

  passwordRepeat: string;

  user: UserRegister = {
    name: '',
    surname: '',
    password: '',
    email: '',
    Role: ''
  };

  constructor(private router: Router , public http : HttpClient) { }

  ngOnInit(): void {
  }

  onSignIn() {

  }

  onRegister() {

    if (this.passwordRepeat !== this.user.password) {
      alert('Molim vas unesite istu sifru.');
    } else if (this.user.password.length < 6) {
      alert('Molim vas unesite sifru vecu od 6 karaktera.');
    } else if (!this.user.email.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {
      alert('Molim vas unesite email u formi : example@example.com');
    }
      // tslint:disable-next-line:
    /*
  else if (! this.user.password.match(/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{6})$/)) {
    alert('Sifra mora da sadrzi mala i velika slova,brojeve i specijalne karaktere i da bude duzine minimum 6.');
  }*/
    else {
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
}
