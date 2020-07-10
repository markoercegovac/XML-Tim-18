import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/AuthService';

@Component({
  selector: 'app-nav-user',
  templateUrl: './nav-user.component.html',
  styleUrls: ['./nav-user.component.css']
})
export class NavUserComponent implements OnInit {

  constructor(
    private router: Router,
    private auth: AuthService) { }

  ngOnInit(): void {
  }


  onHome() {
    this.router.navigate(['/home/ads']);
  }

  onChat() {
    this.router.navigate(['/chat']);
  }

  onLogout() {
    this.auth.logout();
  }

}
