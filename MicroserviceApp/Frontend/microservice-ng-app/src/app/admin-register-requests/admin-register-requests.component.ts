import { Component, OnInit } from '@angular/core';
import { RegistrationRequestModel } from '../model/registretion-request.model';
import { RegistrationRequestsService } from '../services/reqistration-requests.service';

@Component({
  selector: 'app-admin-register-requests',
  templateUrl: './admin-register-requests.component.html',
  styleUrls: ['./admin-register-requests.component.css']
})
export class AdminRegisterRequestsComponent implements OnInit {

  requests: RegistrationRequestModel[] = [];

  constructor(
    private requestService: RegistrationRequestsService
  ) { }

  ngOnInit(): void {
    this.onRefresh();
  }

  onRefresh() {
    this.requestService.getAllRequests().subscribe(
      data => {
        this.requests = data;
      }
    );
  }

}
