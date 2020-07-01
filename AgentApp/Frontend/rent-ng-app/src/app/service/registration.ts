import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserRegister} from '../model/UserRegister';
import {environment} from '../../environments/environment';
import {User} from '../model/User';

const URL: string = environment.registration;

@Injectable({
  providedIn: 'root'
})

export class Registration{
  constructor(private http: HttpClient) {
  }

  public allRegistrationRequests(): Observable<UserRegister[]>{
    return this.http.get<UserRegister[]>(URL + '/all/registration');
  }

  public accept(request: UserRegister){
    return this.http.post(URL + '/request/approve', request);
  }
}
