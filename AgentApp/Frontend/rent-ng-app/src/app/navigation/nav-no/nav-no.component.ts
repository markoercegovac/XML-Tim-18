import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/AuthService';

@Component({
  selector: 'app-nav-no',
  templateUrl: './nav-no.component.html',
  styleUrls: ['./nav-no.component.css']
})
export class NavNoComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onHome() {
    this.router.navigate(['/']);
  }

  onLogin() {
    this.router.navigate(['/sign-in']);
  }

  onRegister() {
    this.router.navigate(['/register']);
  }


}
