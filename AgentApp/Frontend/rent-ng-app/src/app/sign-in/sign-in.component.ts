import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html'
})
export class SignInComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onSignIn() {
    console.log('signing in...');
    this.router.navigate(['/home/ads']);
  }

  onRegister() {
    console.log('go to register');
    this.router.navigate(['/register']);
  }
}
