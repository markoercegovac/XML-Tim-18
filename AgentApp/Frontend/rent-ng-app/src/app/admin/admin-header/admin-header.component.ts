import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styles: [
  ]
})
export class AdminHeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onAdminHome() {
    this.router.navigate(['/admin']);
  }

  onAdminComment() {
    this.router.navigate(['/admin/comment']);
  }

  onLogout() {
    this.router.navigate(['/sign-in']);
  }
}
