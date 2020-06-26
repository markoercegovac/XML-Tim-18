import { Component, OnInit } from '@angular/core';
import {UserRegister} from '../model/UserRegister';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-all-registration-request',
  templateUrl: './all-registration-request.component.html',
  styleUrls: ['./all-registration-request.component.css']
})
export class AllRegistrationRequestComponent implements OnInit {

  zahtevi: UserRegister [];
  constructor(public http: HttpClient) { }

  ngOnInit(): void {
    this.preuzmiSveZahteve();
  }

  preuzmiSveZahteve() {

    this.http.get<any>('http://localhost:9090/admin/all/registration').subscribe(res=> {

      this.zahtevi = res ;
    },
      error => {
        alert('Nesto je poslo naopacke.');
      });


  }

  approve(user: UserRegister) {

  }

  rejected(user: UserRegister) {

  }
}
