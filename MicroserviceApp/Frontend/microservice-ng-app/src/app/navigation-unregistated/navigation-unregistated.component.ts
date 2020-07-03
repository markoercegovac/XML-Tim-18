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
    this.router.navigate(['/home/advert/all']);
  }

  onHome() {
    this.router.navigate(['/home/advert/all']);
  }

  onAllAdverts() {
    this.router.navigate(['/home/advert/all']);
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
