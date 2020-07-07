import {Component, Input, OnInit} from '@angular/core';
import {AdvertMiniModel} from "../../../model/advert-mini.model";
import {Router} from "@angular/router";
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-advert-mini',
  templateUrl: './advert-mini.component.html',
  styleUrls: ['./advert-mini.component.css']
})
export class AdvertMiniComponent implements OnInit {

  @Input('ad') advert: AdvertMiniModel;

  constructor(private router: Router, public cart: CartService) { }

  ngOnInit(): void {

  }

  showFullAdvert() {
    this.router.navigate(['/home/advert', this.advert.advertId]);
  }

  onAddToCart() {
    this.cart.addAdvertIdInCart(this.advert.advertId);
  }
}
