import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';


@Injectable({providedIn: 'root'})
export class AuthService {

  constructor(private http: HttpClient) {}

  login(username: string, password: string ) {
    this.http.post('http:localhost:9090/login', {username, password}, {observe: 'response', responseType: 'text'})
      .subscribe((res: HttpResponse<any>) => {
        console.log('JWT ADDED', res);
        console.log(res.headers)
        console.log(res.headers.get('Authorization'))


        const token = res.headers.get('Authorization');

        localStorage.setItem('token', token);
      });
  }


  logout() {
    console.log('JWT REMOVED');
    localStorage.removeItem('id_token');
  }
}
