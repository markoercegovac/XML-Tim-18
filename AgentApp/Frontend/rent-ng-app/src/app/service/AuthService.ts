import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import * as jwt_decode from 'jwt-decode';
import { Router } from '@angular/router';

const NAVIGATION = ['PERMISSION_USER', 'PERMISSION_OWNER', 'PERMISSION_UNREGISTRATED', 'PERMISSION_ADMIN'];
@Injectable({providedIn: 'root'})
export class AuthService {

  public navigation: string = NAVIGATION[2];
  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  login(username: string, password: string ) {
    this.http.post('http://localhost:9090/login', {username, password}, {observe: 'response', responseType: 'text'})
      .subscribe((res: HttpResponse<any>) => {
        console.log('JWT ADDED');
        console.log(res.headers)
        console.log('JWT TOKEN: ' , res.headers.get('Authorization'))
        this.getPermissions();

        const token = res.headers.get('Authorization');
        localStorage.setItem('token', token);
        this.onLoadNavigation();

      });
  }


  logout() {
    console.log('JWT REMOVED');
    localStorage.removeItem('id_token');
    this.navigation = 'PERMISSION_UNREGISTRATED';
    this.router.navigate(['/sign-in']);
  }

  getPermissions(): string[] {
    let permissions: string[] = [];
    let token = localStorage.getItem("token");
    if(token === null) {
        return permissions;
    }
    let decoted: { [key: string]: string };
    decoted = jwt_decode(token);
    console.log('JWT',decoted);
    for(let i=0; i<decoted['authorities'].length; ++i) {
        permissions.push(decoted['authorities'][i].toString());
    }

    console.log('PERMISSIONS', permissions);
    return permissions;
  }

  onLoadNavigation() {
    if(this.getPermissions().includes('PERMISSION_USER')) {
      this.navigation = 'PERMISSION_USER';
      this.router.navigate(['home']);
    } else if(this.getPermissions().includes('PERMISSION_OWNER')) {
      this.navigation = 'PERMISSION_OWNER';
    } else if(this.getPermissions().includes('PERMISSION_ADMIN')) {
      this.navigation = 'PERMISSION_ADMIN';
      this.router.navigate(['admin']);
    } else {
      this.navigation = 'PERMISSION_UNREGISTRATED';
    }
  }



}
