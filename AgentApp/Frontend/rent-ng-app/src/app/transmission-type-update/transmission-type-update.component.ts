import { Component, OnInit } from '@angular/core';
import {CartransmissionType} from '../model/cartransmission-type';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {CarTransmissionTypeService} from '../servis/car-transmission-type.service';

@Component({
  selector: 'app-transmission-type-update',
  templateUrl: './transmission-type-update.component.html',
  styleUrls: ['./transmission-type-update.component.css']
})
export class TransmissionTypeUpdateComponent implements OnInit {

  id: number;

  model: CartransmissionType;
  constructor(private route: ActivatedRoute, private router: Router, private cttService: CarTransmissionTypeService ) {}

  ngOnInit(): void {
    this.model = new  CartransmissionType();

   // this.id = this.route.snapshot.params.id;
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params.id;
      }
    );


    this.cttService.readCttById(this.id).subscribe(
      data => {
        this.model = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }

    updateC(){
    this.cttService.updateCtt(this.model, this.id).subscribe(
      res => {
     //   location.reload();
      },
      error => {
        alert('Error');
      }
    );
    this.model = new CartransmissionType();
    this.goToList();
  }

  goToList(){
    this.router.navigate([ '/listaCTT' ]);
  }
}
