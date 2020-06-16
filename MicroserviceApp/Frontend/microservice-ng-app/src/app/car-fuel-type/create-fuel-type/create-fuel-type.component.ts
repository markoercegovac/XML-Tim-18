import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef} from '@angular/material/dialog';
import {DialogData} from '../../model/DialogData';
import {CarFuelTypeComponent} from "../car-fuel-type.component";
import {CarFuelType} from "../../model/carFuelType";
import {HttpClient} from "@angular/common/http";
import {CarClass} from "../../model/carClass";

@Component({
  selector: 'app-create-fuel-type',
  templateUrl: './create-fuel-type.component.html',
  styleUrls: ['./create-fuel-type.component.css']
})
export class CreateFuelTypeComponent implements OnInit {

  carFuelType: CarFuelType = {
    id:null,
    fuelType: '',
    isRemoved: false
  }
  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<CreateFuelTypeComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CarFuelType) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

  onYesClick() {

    const urlPost = 'http://localhost:9090/advert-manager/car-fuel-type';
    console.log(this.carFuelType.fuelType);

    this.http.post(urlPost, this.carFuelType).subscribe(res => {
        this.dialogRef.close();
        //location.reload();
        alert('Uspesno kreiran tip');
      },
      error => {
        alert('Error');
      }
    );
  }



}

