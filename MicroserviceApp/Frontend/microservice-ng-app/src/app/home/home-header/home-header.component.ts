import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

const navigation = ['OWNER', 'USER', 'UN_REGISTRATED'];
@Component({
  selector: 'app-home-header',
  templateUrl: './home-header.component.html',
  styleUrls: ['./home-header.component.css']
})
export class HomeHeaderComponent implements OnInit {

  curent: string;
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.checkAuth();
  }

  checkAuth() {
    let auth = this.authService.getPermissions();
    if(auth.includes('PERMISSION_OWNER')) {
      this.curent = navigation[0];
    } else if(auth.includes('PERMISSION_USER')) {
      this.curent = navigation[1];
    } else {
      this.curent = navigation[2];
    }
  }
}
