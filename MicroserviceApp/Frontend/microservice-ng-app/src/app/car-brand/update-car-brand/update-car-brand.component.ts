import {Component, Inject, OnInit} from '@angular/core';
import {CarBrand} from '../../model/CarBrand';
import {HttpClient} from '@angular/common/http';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-update-car-brand',
  templateUrl: './update-car-brand.component.html',
  styleUrls: ['./update-car-brand.component.css']
})
export class UpdateCarBrandComponent implements OnInit {

  carBrand: CarBrand = {
    id: null,
    name: '',
    isRemoved: false

  };
  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<UpdateCarBrandComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CarBrand) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {

    this.carBrand.id = this.data.id;
    this.carBrand.isRemoved = this.data.isRemoved;
    this.carBrand.name = this.data.name;
  }

  onYesClick() {

    const urlPost = 'http://localhost:9090//advert-manager/car-brand';
    console.log(this.carBrand.name);
    this.http.put(urlPost, this.carBrand).subscribe(res => {
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
