import { Component, OnInit } from '@angular/core';
import {CartransmissionType} from '../model/cartransmission-type';
import {CarTransmissionTypeService} from '../servis/car-transmission-type.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-transmission-type',
  templateUrl: './transmission-type.component.html',
  styleUrls: ['./transmission-type.component.css']
})
export class TransmissionTypeComponent implements OnInit {

  model: CartransmissionType = new CartransmissionType();

  constructor(private cttService: CarTransmissionTypeService, private router: Router) { }

  ngOnInit(): void {}

  createC(){
    this.cttService.createCtt(this.model).subscribe(
      res => {
        location.reload();
      },
      error => {
        alert('Error');
      }
    );
    this.model = new CartransmissionType();
    this.goToList();
  }

  goToList() {
    this.router.navigate(['/listaCTT']);
  }
}
