import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-header',
  templateUrl: './home-header.component.html',
  styles: [
  ]
})
export class HomeHeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onSignIn() {
    this.router.navigate(['/sign-in']);
  }

  onRegister() {
    this.router.navigate(['/register']);
  }

  onHome() {
    this.router.navigate(['/home/ads']);
  }
}
