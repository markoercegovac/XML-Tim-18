import {Component, Inject, OnInit} from '@angular/core';
import {AdvertReservationReq} from '../../../model/AdvertReservationReq';
import {HttpClient} from '@angular/common/http';

import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {ReservationAdvertService} from '../../../service/reservation-advert-service';

@Component({
  selector: 'app-reservation-date',
  templateUrl: './reservation-date.component.html',
  styleUrls: ['./reservation-date.component.css']
})
export class ReservationDateComponent implements OnInit {


  AdvReq: AdvertReservationReq = {
    advertId: null,
    dateStart: new Date(),
    dateEnd: new Date()

  };
  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<ReservationDateComponent>,
              @Inject(MAT_DIALOG_DATA) public data: AdvertReservationReq ,
              public reservationService: ReservationAdvertService) { }


  ngOnInit(): void {
    this.AdvReq.advertId = this.data.advertId;

    console.log('id:' + this.AdvReq.advertId);

  }

  onYesClick() {

    this.reservationService.saveAdvertRequest(this.AdvReq).subscribe(
      res => {  this.dialogRef.close(); alert('Successfully send reservation for this advert.');},
      error => {alert('Something went wrong'); } );
    console.log('---------------------------------');
    console.log(this.AdvReq.dateStart);
    console.log(this.AdvReq.dateEnd);

  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
