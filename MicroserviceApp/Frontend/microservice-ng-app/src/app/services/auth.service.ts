import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


const BASE_URL = 'http://localhost:8081/user-manager';

@Injectable({providedIn: 'root'})
export class AuthService {
    
    constructor(private http: HttpClient) {}

    login(email:string, password:string ) {
        this.http.post(BASE_URL+'/login', {email: email, password: password})
            .subscribe((res: any) => {
                console.log('JWT ADDED');
                localStorage.setItem('token', res.token);
            }); 
    }
                  

    logout() {
        console.log('JWT REMOVED');
        localStorage.removeItem("id_token");
    }
}