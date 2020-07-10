import { Component, OnInit } from '@angular/core';
import {UserRegister} from '../model/UserRegister';
import {Registration} from '../service/registration';

@Component({
  selector: 'app-all-registration-request',
  templateUrl: './all-registration-request.component.html',
  styleUrls: ['./all-registration-request.component.css']
})
export class AllRegistrationRequestComponent implements OnInit {

  zahtevi: UserRegister [];
  constructor(private registerService: Registration) { }

  ngOnInit(): void {
    this.registerService.allRegistrationRequests().subscribe(res => {

        this.zahtevi = res ;

      },
      error => {
        alert('Nesto je poslo naopacke.');
      });
  }






  public approve(register: UserRegister) {
    let req: UserRegister;
    // @ts-ignore
    req = {email: register.email, password: register.password, name: register.name, surname: register.surname, role: register.role, city: register.city, username: register.email};
    this.registerService.accept(req).subscribe();
    alert(req.email);
  }

    public rejected(user: UserRegister) {


    this.registerService.reject(user).subscribe(
      res => { alert('Uspesno odbijen zahtv.'); } ,
        error => { alert('Nesto je krenulo naopacke.'); });

  }
}
