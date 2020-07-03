import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import * as jwt_decode from 'jwt-decode';
import { Router } from '@angular/router';

const BASE_URL = environment.zuul;
const NAVIGATION = ['USER', 'OWNER', 'UNREGISTRATED'];

@Injectable({providedIn: 'root'})
export class AuthService {

    public navigation: string = NAVIGATION[2];
    constructor(private http: HttpClient, private router: Router) {}

    login(username:string, password:string ) {
        this.logout();
        let headers = new HttpHeaders({
          'Content-Type':  'application/x-www-form-urlencoded; charset=utf-8',
          'Authorization': 'Basic ' + btoa('user-manager:user123')
        })


        let params=new URLSearchParams();
        params.append('username',username);
        params.append('password',password);
        params.append('grant_type','password');
        params.append('client_id','user-manager');
        params.append('client_secret','user123');

        this.http.post( BASE_URL+"/oauth/token",params.toString(),{headers:headers})
            .subscribe((data:any) => {
                console.log('JWT ADDED', data);

                let token=data.access_token;
                localStorage.setItem('token', token);

                if(this.getPermissions().includes('PERMISSION_ADMIN')) {
                    this.router.navigate(['/admin']);
                } else {
                    this.onLoadNavigation();
                    this.router.navigate(['/home']);
                }
            }, error => {
                alert('EMAIL OR PASSWORD IS INCORECT');
            });

    }

    logout() {
        console.log('JWT REMOVED');
        localStorage.removeItem("token");
        this.router.navigate(['/home']);
        this.onLoadNavigation();
    }

    getPermissions(): string[] {
        let permissions: string[] = [];
        let token = localStorage.getItem("token");
        if(token === null) {
            return permissions;
        }
        let decoted: { [key: string]: string };
        decoted = jwt_decode(token);
        console.log(decoted);
        for(let i=0; i<decoted['authorities'].length; ++i) {
            permissions.push(decoted['authorities'][i]['authority'].toString());
        }

        return permissions;
    }

    getCurrentUserEmail(): string {
        let token = localStorage.getItem("token");
        if(token === null) {
            return null;
        }
        let decoted: { [key: string]: string };
        decoted = jwt_decode(token);
        
        return decoted["username"];
    }

    onLoadNavigation() {
        if(this.getPermissions().includes('PERMISSION_USER')) {
          this.navigation = NAVIGATION[0];
        } else if(this.getPermissions().includes('PERMISSION_OWNER')) {
          this.navigation = NAVIGATION[1];
        } else {
          this.navigation = NAVIGATION[2];
        }
      }
}
