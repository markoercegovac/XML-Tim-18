import { Component, OnInit } from '@angular/core';
import {UserRegister} from '../model/UserRegister';
import {HttpClient} from "@angular/common/http";
import {Registration} from '../service/registration';
import {User} from '../model/User';

@Component({
  selector: 'app-all-registration-request',
  templateUrl: './all-registration-request.component.html',
  styleUrls: ['./all-registration-request.component.css']
})
export class AllRegistrationRequestComponent implements OnInit {

  zahtevi: UserRegister [];
  constructor(private registerService: Registration) { }

  ngOnInit(): void {
    this.registerService.allRegistrationRequests().subscribe(res=> {

        this.zahtevi = res ;

      },
      error => {
        alert('Nesto je poslo naopacke.');
      });
  }






  public approve(register: UserRegister) {
    let req: UserRegister;
    req={email:register.email,password:register.password,name:register.name,surname:register.surname,Role:register.Role}
    this.registerService.accept(req).subscribe();
    alert(req.email);
  }

  rejected(user: UserRegister) {

  }
}
