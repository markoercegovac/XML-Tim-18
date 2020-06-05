import {Component, Inject, OnInit} from '@angular/core';
import {CarTranssmisionType} from "../../model/CarTranssmisionType";
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-update-car-transmission',
  templateUrl: './update-car-transmission.component.html',
  styleUrls: ['./update-car-transmission.component.css']
})
export class UpdateCarTransmissionComponent implements OnInit {

  carTranss: CarTranssmisionType = {
    id: null,
    transmissionType: '',
    isRemoved: false
  }
  constructor(public http: HttpClient,
              public dialogRef: MatDialogRef<UpdateCarTransmissionComponent>,
              @Inject(MAT_DIALOG_DATA) public carTranssa: CarTranssmisionType) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.carTranss.transmissionType = this.carTranssa.transmissionType;
    this.carTranss.id = this.carTranssa.id;
    this.carTranss.isRemoved = this.carTranssa.isRemoved;
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
