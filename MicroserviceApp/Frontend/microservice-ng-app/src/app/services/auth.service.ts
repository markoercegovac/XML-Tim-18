import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import * as jwt_decode from 'jwt-decode';

const BASE_URL = environment.zuul;

@Injectable({providedIn: 'root'})
export class AuthService {

    constructor(private http: HttpClient) {}

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

                console.log(this.getPermissions())
            });
    }

    logout() {
        console.log('JWT REMOVED');
        localStorage.removeItem("token");
    }

    getPermissions(): string[] {
        let permissions: string[] = [];
        let token = localStorage.getItem("token");
        let decoted: { [key: string]: string };
        decoted = jwt_decode(token);

        for(let i=0; i<decoted['authorities'].length; ++i) {
            permissions.push(decoted['authorities'][i]['authority'].toString());
        }

        return permissions;
    }
}
