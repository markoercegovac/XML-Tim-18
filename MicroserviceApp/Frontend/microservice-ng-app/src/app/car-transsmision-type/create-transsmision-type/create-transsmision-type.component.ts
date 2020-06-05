import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {DialogData} from "../../model/DialogData";
import {CarTranssmisionType} from "../../model/CarTranssmisionType";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-create-transsmision-type',
  templateUrl: './create-transsmision-type.component.html',
  styleUrls: ['./create-transsmision-type.component.css']
})
export class CreateTranssmisionTypeComponent implements OnInit {

  carTranss: CarTranssmisionType = {
    id: null,
    transmissionType: '',
    isRemoved: false
  }
  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<CreateTranssmisionTypeComponent>,
     @Inject(MAT_DIALOG_DATA) public carTranssa: CarTranssmisionType) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
  }

  onYesClick() {

      const urlPost = 'http://localhost:9090//advert-manager/car-transmission';

      console.log(this.carTranss.transmissionType);

      this.http.post(urlPost, this.carTranss).subscribe( res => {
          this.dialogRef.close();
          location.reload();
          alert('Uspesno kreiran tip'  );
        },
        error => {
          alert('Error');
        }

      );

    }
  }


