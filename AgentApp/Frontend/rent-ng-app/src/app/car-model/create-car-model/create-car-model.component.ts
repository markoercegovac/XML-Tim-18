import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

import {CarModel} from '../../model/carModel';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-create-car-model',
  templateUrl: './create-car-model.component.html',
  styleUrls: ['./create-car-model.component.css']
})
export class CreateCarModelComponent implements OnInit {

  carModel: CarModel = {
    id: null,
    modelName: '',
    isRemoved: false

  };

  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<CreateCarModelComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CarModel) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

  onYesClick() {

    const urlPost = 'http://localhost:9090/car-model';

    console.log(this.carModel.modelName);

    this.http.post(urlPost, this.carModel).subscribe( res => {
        this.dialogRef.close();
        // location.reload();
        alert('Uspesno kreiran tip'  );
      },
      error => {
        alert('Error');
      }

    );
  }
}
