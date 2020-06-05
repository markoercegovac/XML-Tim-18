import {Component, Inject, OnInit} from '@angular/core';
import {CarModel} from "../../model/CarModel";
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-update-car-model',
  templateUrl: './update-car-model.component.html',
  styleUrls: ['./update-car-model.component.css']
})
export class UpdateCarModelComponent implements OnInit {

  carModell: CarModel = {
    id: null,
    modelName: '',
    isRemoved: false

  }

  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<UpdateCarModelComponent>,
              @Inject(MAT_DIALOG_DATA) public carModel: CarModel) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {

    this.carModell.modelName = this.carModel.modelName;
    this.carModell.id = this.carModel.id;
    this.carModell.isRemoved = this.carModell.isRemoved;

  }

  onYesClick() {

    const urlPost = 'http://localhost:9090/advert-manager/car-model';

    console.log(this.carModell.modelName);

    this.http.post(urlPost, this.carModell).subscribe( res => {
        this.dialogRef.close();
        //location.reload();
        alert('Uspesno kreiran tip'  );
      },
      error => {
        alert('Error');
      }

    );
  }

}
