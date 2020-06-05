import {Component, Inject, OnInit} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {HttpClient} from '@angular/common/http';

import {MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef} from '@angular/material/dialog';
import {DialogData} from '../../model/DialogData';
import {CarBrand} from "../../model/CarBrand";
import {CarBrandComponent} from "../car-brand.component";


@Component({
  selector: 'app-create-car-brand',
  templateUrl: './create-car-brand.component.html',
  styleUrls: ['./create-car-brand.component.css']
})

export class CreateCarBrandComponent implements OnInit {


  carBrand: CarBrand = {
    id: null,
    name: '',
    isRemoved: false

  }
  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<CreateCarBrandComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CarBrand) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

  onYesClick() {

    const urlPost = 'http://localhost:9090//advert-manager/car-brand';

    console.log(this.carBrand.name);

    this.http.post(urlPost, this.carBrand).subscribe(res => {
        this.dialogRef.close();

        alert('Uspesno kreiran tip');
      },
      error => {
        alert('Error');
      }
    );
  }
}
