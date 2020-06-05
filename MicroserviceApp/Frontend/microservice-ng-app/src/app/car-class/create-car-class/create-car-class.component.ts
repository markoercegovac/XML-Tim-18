import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef} from '@angular/material/dialog';
import {CarClass} from '../../model/CarClass';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-create-car-class',
  templateUrl: './create-car-class.component.html',
  styleUrls: ['./create-car-class.component.css']
})
export class CreateCarClassComponent implements OnInit {

  carClass: CarClass = {
    id: null,
    className: '',
    isRemoved: false
  }

  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<CreateCarClassComponent>,
              @Inject(MAT_DIALOG_DATA) public data: CarClass) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
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
