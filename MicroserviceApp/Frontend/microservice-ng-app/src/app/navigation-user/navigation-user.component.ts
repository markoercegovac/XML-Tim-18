import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-navigation-user',
  templateUrl: './navigation-user.component.html',
  styleUrls: ['./navigation-user.component.css']
})
export class NavigationUserComponent implements OnInit {

  navbarCollapsed: boolean = false;
  constructor(
    private router: Router,
    private authService: AuthService
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

  onMessages() {
    this.router.navigate(['/home/message', this.authService.getCurrentUserEmail()]);
  }

  onLogout() {
    this.authService.logout();
  }

  onCart() {
    this.router.navigate(['/home/cart']);
  }

}
