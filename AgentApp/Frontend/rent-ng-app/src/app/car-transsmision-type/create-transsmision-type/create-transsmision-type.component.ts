import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';


import {HttpClient} from '@angular/common/http';
import {CarTransmission} from '../../model/carTransmission';

@Component({
  selector: 'app-create-transsmision-type',
  templateUrl: './create-transsmision-type.component.html',
  styleUrls: ['./create-transsmision-type.component.css']
})
export class CreateTranssmisionTypeComponent implements OnInit {

  carTranss: CarTransmission = {
    id: null,
    transmissionType: '',
    isRemoved: false
  };
  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<CreateTranssmisionTypeComponent>,
              @Inject(MAT_DIALOG_DATA) public carTranssa: CarTransmission) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

  onYesClick() {

      const urlPost = 'http://localhost:9090/car-transsmision-type';

      console.log(this.carTranss.transmissionType);

      this.http.post(urlPost, this.carTranss).subscribe( res => {
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


