import { Component, OnInit } from '@angular/core';
import { AuthService } from './service/AuthService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'rent-ng-app';

  constructor(
    private auth: AuthService
  ) {}

  ngOnInit() {
    this.auth.onLoadNavigation();
  }

}
