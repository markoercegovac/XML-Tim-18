import {Component, Inject, OnInit} from '@angular/core';
import {CarModel} from "../../model/carModel";
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-update-car-model',
  templateUrl: './update-car-model.component.html',
  styleUrls: ['./update-car-model.component.css']
})
export class UpdateCarModelComponent implements OnInit {

  carModel: CarModel = {
    id: null,
    modelName: '',
    isRemoved: false

  }

  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<UpdateCarModelComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CarModel) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {

    this.carModel.modelName = this.data.modelName;
    this.carModel.id = this.data.id;
    this.carModel.isRemoved = this.data.isRemoved;

  }

  onYesClick() {

    const urlPost = 'http://localhost:9090/advert-manager/car-model';

    console.log(this.carModel.modelName);

    this.http.put(urlPost, this.carModel).subscribe( res => {
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
