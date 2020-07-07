import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'microservice-ng-app';
  constructor(
    private auth: AuthService
  ) {
  }

  ngOnInit() {
    if(this.auth.getCurrentUserEmail() != null) {
      this.auth.onLoadNavigation();
    }
  }
}
