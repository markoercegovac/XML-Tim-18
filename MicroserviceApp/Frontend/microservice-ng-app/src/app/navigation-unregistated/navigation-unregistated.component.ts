import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation-unregistated',
  templateUrl: './navigation-unregistated.component.html',
  styleUrls: ['./navigation-unregistated.component.css']
})
export class NavigationUnregistatedComponent implements OnInit {

  navbarCollapsed: boolean = false;
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onHome() {
    this.router.navigate(['/home/advert/all']);
  }

  onCreateAdvert() {
    this.router.navigate(['/home/create/advert']);
  }

  onMyAdverts() {
    this.router.navigate(['/home/my/adverts']);
  }

  onAllAdverts() {
    this.router.navigate(['/home/advert/all']);
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
