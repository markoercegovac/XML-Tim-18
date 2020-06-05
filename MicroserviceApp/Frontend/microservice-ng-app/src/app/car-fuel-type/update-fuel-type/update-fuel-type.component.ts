import {Component, Inject, OnInit} from '@angular/core';
import {CarFuelType} from "../../model/CarFuelType";
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-update-fuel-type',
  templateUrl: './update-fuel-type.component.html',
  styleUrls: ['./update-fuel-type.component.css']
})
export class UpdateFuelTypeComponent implements OnInit {

  carFuelType: CarFuelType = {
    id: null,
    fuelType: '',
    isRemoved: false
  }
  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<UpdateFuelTypeComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CarFuelType) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {

    this.carFuelType.fuelType = this.data.fuelType;
    this.carFuelType.id = this.data.id;
    this.carFuelType.isRemoved = this.data.isRemoved;
  }


  onYesClick() {

    const urlPost = 'http://localhost:9090/advert-manager/car-fuel-type';
    console.log(this.carFuelType.id);
    console.log(this.carFuelType.fuelType);
    this.http.put(urlPost, this.carFuelType).subscribe(res => {
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
