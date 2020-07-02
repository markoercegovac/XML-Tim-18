import { Component, OnInit } from '@angular/core';
import {Price} from '../../../model/price';
import {PriceService} from '../../../services/price.service';
import {HttpClient} from '@angular/common/http';
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-define-price',
  templateUrl: './define-price.component.html',
  styleUrls: ['./define-price.component.css']
})
export class DefinePriceComponent implements OnInit {


  model: Price = {
    id: 0,
    priceName: '',
    pricePerDay: 0,
    insurancePrice: 0,
    distanceOverflowPrice: 0,
  }

  constructor(private http: HttpClient, private priceService: PriceService, private router: Router) { }

  ngOnInit(): void {
  }

  createPrice(): void{
    this.priceService.createPrice(this.model).subscribe(
      data => {
        this.router.navigate(["/home/create/advert"]);
      }, error => {
        alert('SERVER ERROR');
      }
    );
  }
}
