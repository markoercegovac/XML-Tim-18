import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  navbarCollapsed: boolean = false;
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onHome() {
    this.router.navigate(['/home']);
  }

  onCreateAdvert() {
    this.router.navigate(['/home/create/advert']);
  }

  onMyAdverts() {
    this.router.navigate(['/home/my/adverts']);
  }

  onAllAdverts() {
    this.router.navigate(['/home/all/adverts']);
  }

  onCars() {
    this.router.navigate(['/home/my/cars']);
  }

  onPriceList() {
    this.router.navigate(['/home/my/price/list']);
  }

  onLogin() {
    this.router.navigate(['/home/login']);
  }

  onRegister() {
    this.router.navigate(['/home/register']);
  }

  onCart() {
    this.router.navigate(['/home/cart']);
  }

}
