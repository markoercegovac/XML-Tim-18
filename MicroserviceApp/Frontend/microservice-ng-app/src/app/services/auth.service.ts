import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { environment } from 'src/environments/environment';


const BASE_URL = environment.zuul;

@Injectable({providedIn: 'root'})
export class AuthService {

    constructor(private http: HttpClient) {}

    login(username:string, password:string ) {
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

        this.http.post("http://localhost:8662/oauth/token",params.toString(),{headers:headers})
            .subscribe(data => {
                console.log('JWT ADDED', data);

                console.log(data.access_token);
                let token=data.access_token;
                localStorage.setItem('token', token);

            });
    }
    saveToken(token){
    }


    logout() {
        console.log('JWT REMOVED');
        localStorage.removeItem("id_token");
    }
}
