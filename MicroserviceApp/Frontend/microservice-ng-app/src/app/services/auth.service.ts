import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';


const BASE_URL = 'http://localhost:8081';

@Injectable({providedIn: 'root'})
export class AuthService {
    
    constructor(private http: HttpClient) {}

    login(username:string, password:string ) {
        this.http.post(BASE_URL+'/login', {username: username, password: password}, {observe: 'response'})
            .subscribe((res: HttpResponse<any>) => {
                console.log('JWT ADDED', res);
                console.log(res.headers)
                console.log(res.headers.get('Authorization'))


                let token = res.headers.get('Authorization');

                localStorage.setItem('token', token);
            }); 
    }
                  

    logout() {
        console.log('JWT REMOVED');
        localStorage.removeItem("id_token");
    }
}