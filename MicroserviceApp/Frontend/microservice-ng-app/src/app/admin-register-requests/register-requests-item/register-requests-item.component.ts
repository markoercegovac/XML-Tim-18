import { Component, Input, Output, EventEmitter } from '@angular/core';
import { RegistrationRequestModel } from 'src/app/model/registretion-request.model';
import { RegistrationRequestsService } from 'src/app/services/reqistration-requests.service';

@Component({
  selector: 'app-register-requests-item',
  templateUrl: './register-requests-item.component.html',
  styleUrls: ['./register-requests-item.component.css']
})
export class RegisterRequestsItemComponent {

  @Input('request') request: RegistrationRequestModel;
  @Output('refresh') refresh = new EventEmitter<void>();
  constructor(
    private requestService: RegistrationRequestsService
  ) { }

  onBless() {
    this.requestService.bless(this.request.email);
    this.refresh.emit();
  }

  onDecline() {
    this.requestService.decline(this.request.email);
    this.refresh.emit();
  }
}
