import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/AuthService';

@Component({
  selector: 'app-nav-owner',
  templateUrl: './nav-owner.component.html',
  styleUrls: ['./nav-owner.component.css']
})
export class NavOwnerComponent implements OnInit {

  constructor(
    private router: Router,
    private auth: AuthService) { }

  ngOnInit(): void {
  }

  onCreate() {
    this.router.navigate(['/registerCar']);
  }

  onAdvert() {
    this.router.navigate(['/home/ad/add']);
  }

  onPrice() {
    this.router.navigate(['/definePrice']);
  }

  onHome() {
    this.router.navigate(['/my/adverts']);
  }

  onReport() {
    this.router.navigate(['/kreirajDR']);
  }

  onChat() {
    this.router.navigate(['/inbox']);
  }

  onLogout() {
    this.auth.logout();
  }

}
