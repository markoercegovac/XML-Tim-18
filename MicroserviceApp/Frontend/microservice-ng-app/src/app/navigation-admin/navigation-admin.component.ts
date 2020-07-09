import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation-admin',
  templateUrl: './navigation-admin.component.html',
  styleUrls: ['./navigation-admin.component.css']
})
export class NavigationAdminComponent implements OnInit {

  navbarCollapsed: boolean = false;
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  onAdmin() {
    this.router.navigate(["/admin"]);
  }

  public onBrand() {
    this.router.navigate(["/admin/brand"]);
  }

  onClass() {
    this.router.navigate(["admin/class"]);
  }

  onModel() {
    this.router.navigate(["/admin/model"]);
  }

  onFuel() {
    this.router.navigate(["/admin/fuel-type"]);
  }

  onTransmission() {
    this.router.navigate(["/admin/transmission"]);
  }

  onComment() {
    this.router.navigate(["/admin/comment"]);
  }

  onBan() {
    this.router.navigate(["/admin/ban"]);
  }

  onLogout() {
    this.authService.logout();
  }

  onRegistration() {
    this.router.navigate(["/admin/registration-requests"]);
  }

  onUserList() {
    this.router.navigate(["/admin/ban/user"])
  }
}
