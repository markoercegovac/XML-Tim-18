import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-register-approved',
  templateUrl: './register-approved.component.html',
  styleUrls: ['./register-approved.component.css']
})
export class RegisterApprovedComponent implements OnInit {

  email: string;

  constructor(private route: ActivatedRoute, public http: HttpClient) { }

  ngOnInit(): void {

    this.route.params.subscribe(
      (params: Params) => {
        this.email = params.email;
      }
    );
    console.log(this.email);

    this.http.post('http://localhost:9090/create-client/' + this.email , null).subscribe();

  }

}
