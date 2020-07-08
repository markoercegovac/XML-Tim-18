import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {User} from '../model/User';
import {UserRegister} from '../model/UserRegister';

const URL = environment.client;

@Injectable({
  providedIn: 'root'
})

export class ClientService {
  constructor(private http: HttpClient) {
  }
  public getAllAcceptedOwnersEmails(): Observable<UserRegister[]>{
    return this.http.get<UserRegister[]>(URL + '/all-owners');
  }
}
