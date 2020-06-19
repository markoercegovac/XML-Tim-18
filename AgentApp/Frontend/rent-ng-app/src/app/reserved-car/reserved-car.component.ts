import { Component, OnInit } from '@angular/core';
import {Reservation} from '../model/reservation';
import {ActivatedRoute} from '@angular/router';
import {AdvertService} from '../service/advert-service';

@Component({
  selector: 'app-reserved-car',
  templateUrl: './reserved-car.component.html',
  styleUrls: ['./reserved-car.component.css']
})
export class ReservedCarComponent implements OnInit {

  adId: number = 0;
  allReservation: Reservation[];

  startDate: Date;
  endDate: Date;

  constructor(private activeUrl: ActivatedRoute,private advertService: AdvertService) { }

  ngOnInit(): void {
    this.adId = +this.activeUrl.snapshot.params['id'];
    this.renderTable();
  }

  public createReservation(){
    let capture: Reservation;

    capture=new Reservation(null,this.startDate,this.endDate,this.adId);
    this.advertService.createReservation(capture).subscribe(data=>this.renderTable());
  }

  private renderTable() {
    this.advertService.allReservationForAdvert(this.adId).subscribe(
      data=>{
        this.allReservation=data;
      }
    );
  }
}
