import { Component, OnInit } from '@angular/core';
import {PriceService} from "../../../services/price.service";
import {Price} from "../../../model/price";

@Component({
  selector: 'app-my-price-list',
  templateUrl: './my-price-list.component.html',
  styleUrls: ['./my-price-list.component.css']
})
export class MyPriceListComponent implements OnInit {

  allMyPrices:Price[];

  constructor(private priceService: PriceService) { }

  ngOnInit(): void {
    this.priceService.getUserPriceList().subscribe(
      data=>{
        this.allMyPrices=data;
      }
    )
  }

}
