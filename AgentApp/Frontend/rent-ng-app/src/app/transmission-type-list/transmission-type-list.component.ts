import { Component, OnInit } from '@angular/core';
import {CartransmissionType} from '../model/cartransmission-type';
import {CarTransmissionTypeService} from '../servis/car-transmission-type.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-transmission-type-list',
  templateUrl: './transmission-type-list.component.html',
  styleUrls: ['./transmission-type-list.component.css']
})
export class TransmissionTypeListComponent implements OnInit {
  title = 'Car transmission Type';
  typeC: CartransmissionType[];
  constructor(private cttService: CarTransmissionTypeService, private router: Router) { }

  ngOnInit(): void {
    this.cttService.readCtt().subscribe(
      data => {
        this.typeC = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

  updateC(ctt: CartransmissionType, id: number){
    this.router.navigate(['updateCTT', id]);
  }

  deleteC(id: number, ctt: CartransmissionType){
    this.cttService.deleteCtt(id, ctt).subscribe(
      res => {
   //     location.reload();
        this.typeC.pop();
      },
      error => {
        alert('Error');
      }
    );
  }
}
