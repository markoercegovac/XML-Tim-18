import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AdvertFullModel } from '../../model/advert-full.model';
import {AdvertService} from '../../service/advert-service';
import {ReservationDateComponent} from './reservation-date/reservation-date.component';

@Component({
  selector: 'app-full-advert',
  templateUrl: './full-advert.component.html',
  styles: [
  ]
})
export class FullAdvertComponent implements OnInit {

  adId: number;
  advert: AdvertFullModel;
  grade: number;


  constructor(private currentUrl: ActivatedRoute, public advertService: AdvertService, public dialog: MatDialog) { }

  ngOnInit(): void {

    this.adId = +this.currentUrl.snapshot.params.id;
    this.advertService.getGradeForAdvert(this.adId).subscribe(
      data => {
        this.grade = data;
      }
    );

    this.advertService.getAdvert(this.adId).subscribe(
      data => {
        this.advert = data;
        console.log(this.advert);
      }
    );

    console.log(this.adId);

  }



  openDialog(): void {
    const dialogRef = this.dialog.open(ReservationDateComponent, {
      width: '250px',
      data: {advertId: this.adId}
    });

    dialogRef.afterClosed().subscribe(result => {


    });
  }
  createGrade() {

  }
}
