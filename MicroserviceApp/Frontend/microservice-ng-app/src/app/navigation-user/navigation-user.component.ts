import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-navigation-user',
  templateUrl: './navigation-user.component.html',
  styleUrls: ['./navigation-user.component.css']
})
export class NavigationUserComponent implements OnInit {

  navbarCollapsed: boolean = false;
  constructor(
    private router: Router,
    private authService: AuthService,
    private http: HttpClient
    ) { }

  ngOnInit(): void {
    this.router.navigate(['/home/advert/all']);
  }

  onHome() {
    this.router.navigate(['/home/advert/all']);
  }

  onAllAdverts() {
    this.router.navigate(['/home/advert/all']);
  }

  onRequests() {
    this.router.navigate(['/home/requests']);
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

  onSearch() {
    this.router.navigate(['/searchAdvanced']);
    this.http.get('http://localhost:8662/search-manager/objects').subscribe();
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

  onCart() {
    this.router.navigate(['/home/cart']);
  }

}
