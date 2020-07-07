import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(
    public cart: CartService,
    private router: Router,
    private auth: AuthService
  ) { }

  ngOnInit(): void {
    //this.mock();
  }

  onCheck() {
    if(this.auth.getPermissions().includes('PERMISSION_USER')) {
      this.router.navigate(['home/bundle']);
    } else {
      alert('To continue, you have to be registrated!');
    
      window.localStorage.setItem('cart', JSON.stringify(this.cart.getAllAdverts()));
    }
  }

  private mock() {
    this.cart.addAdvertInCart({advertId: 101, ownerEmail: 'pera@mail', profileImage: 'img1', startDate: new Date(), endDate: new Date(), price: 256});
    this.cart.addAdvertInCart({advertId: 102, ownerEmail: 'pera@mail', profileImage: 'img2', startDate: new Date(), endDate: new Date(), price: 256});
    this.cart.addAdvertInCart({advertId: 103, ownerEmail: 'pera@mail', profileImage: 'img3', startDate: new Date(), endDate: new Date(), price: 256});
    this.cart.addAdvertInCart({advertId: 104, ownerEmail: 'mika@mail', profileImage: 'img4', startDate: new Date(), endDate: new Date(), price: 256});
    this.cart.addAdvertInCart({advertId: 105, ownerEmail: 'mika@mail', profileImage: 'img5', startDate: new Date(), endDate: new Date(), price: 256});
  }

}
