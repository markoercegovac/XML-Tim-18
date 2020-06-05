import { Component, OnInit, Input } from '@angular/core';
import { AdvertInCartModel } from 'src/app/model/advert-in-cart.model';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.css']
})
export class CartItemComponent implements OnInit {

  @Input('advert') advert: AdvertInCartModel;

  constructor(private cart: CartService) { }

  ngOnInit(): void {
  }

  onCancel() {
    this.cart.removeAdvertFromCart(this.advert.advertId);
  }

}
