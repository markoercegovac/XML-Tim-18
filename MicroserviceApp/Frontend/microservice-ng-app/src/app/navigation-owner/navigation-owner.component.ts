import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-navigation-owner',
  templateUrl: './navigation-owner.component.html',
  styleUrls: ['./navigation-owner.component.css']
})
export class NavigationOwnerComponent implements OnInit {

  navbarCollapsed: boolean = false;
  constructor(
    private router: Router,
    private authService: AuthService
    ) { }

  ngOnInit(): void {
    this.router.navigate(['/home/owner/requests']);
  }

  onViewRequests() {
    this.router.navigate(['/home/owner/requests']);
  }

  onMessages() {
    this.router.navigate(['/home/message', this.authService.getCurrentUserEmail()]);
  }

  onAdverts() {
    this.router.navigate(['/home/my/adverts']);
  }

  onCreateAdvert() {
    this.router.navigate(['/home/create/advert']);
  }

  onCars() {
    this.router.navigate(['/home/my/cars']);
  }

  onRegisterCar() {
    this.router.navigate(['/home/register/car']);
  }

  onPrices() {
    this.router.navigate(['/home/my/price/list']);
  }

  onCreatePrices() {
    this.router.navigate(['/home/define/price']);
  }

  onLogout() {
    this.authService.logout();
  }
}
