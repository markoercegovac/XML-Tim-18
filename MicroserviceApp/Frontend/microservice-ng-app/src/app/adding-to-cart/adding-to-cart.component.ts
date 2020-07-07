import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-adding-to-cart',
  templateUrl: './adding-to-cart.component.html',
  styleUrls: ['./adding-to-cart.component.css']
})
export class AddingToCartComponent implements OnInit{

  InputEndDate: Date;
  InputStartDate: Date;
  error: boolean;

  constructor(
    public dialogRef: MatDialogRef<AddingToCartComponent>
  ) { }

    ngOnInit() {
      this.InputEndDate = new Date();
      this.InputStartDate = new Date();
      this.error = false;
    }

  submit(form: NgForm) {
    this.error = false;

    if(this.InputEndDate > this.InputStartDate) {
      this.dialogRef.close({start: this.InputStartDate, end: this.InputEndDate});
    } else {
      this.error = true;
    }
  }

  onCancel() {
    this.dialogRef.close({start: null, end: null});
  }

}
