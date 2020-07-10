import { Component, OnInit } from '@angular/core';
import {Price} from '../model/price';
import {PriceService} from '../service/price-service';

@Component({
  selector: 'app-define-price',
  templateUrl: './define-price.component.html',
  styleUrls: ['./define-price.component.css']
})



export class DefinePriceComponent implements OnInit {
  model: Price = {
    id: 0,
    name: '',
    pricePerDay: 0,
    insurancePrice: 0,
    distanceOverflowPrice: 0,
    discount: 0,
    isRemoved: false,
  }
  constructor(private priceService: PriceService) { }

  ngOnInit(): void {
  }

  createPrice() {
    this.priceService.createPrice(this.model).subscribe(
      data=>{

        alert("Price succesfully created")
        console.log(this.model);
      },error => {
        alert("Error occured");
      }
    );
  }
}
