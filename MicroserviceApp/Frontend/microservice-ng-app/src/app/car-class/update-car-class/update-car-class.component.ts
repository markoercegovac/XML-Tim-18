import {Component, Inject, OnInit} from '@angular/core';
import {CarClass} from "../../model/CarClass";
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-update-car-class',
  templateUrl: './update-car-class.component.html',
  styleUrls: ['./update-car-class.component.css']
})
export class UpdateCarClassComponent implements OnInit {

  carClass: CarClass = {
    id: null,
    className: '',
    isRemoved: false
  }

  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<UpdateCarClassComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CarClass) {
  }


  ngOnInit(): void {

  this.carClass.className = this.data.className;
  this.carClass.id = this.data.id;
  this.carClass.isRemoved = this.data.isRemoved;
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onYesClick() {

    const urlPost = 'http://localhost:9090/advert-manager/car-class';

    console.log(this.carClass.className);

    this.http.post(urlPost, this.carClass).subscribe(res => {
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
