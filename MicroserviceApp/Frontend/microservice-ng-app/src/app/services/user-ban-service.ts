// const BASE_URl = environment.advertManagerUrl+ '/advert/';
import {environment} from '../../environments/environment';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserBan} from "../model/UserBan";

const BASE_URl = environment.zuul + '/user-manager/admin';
const ForbiddenUserURL=environment.zuul+'/advert-manager/forbid'

@Injectable({providedIn: 'root'})
export class UserBanService {

  constructor(
    private http: HttpClient
  ) {}

  public getAllUsers():Observable<UserBan[]>  {
    return this.http.get<UserBan[]>(BASE_URl + '/all');
  }

  public ban(element: UserBan) {
    return this.http.post(BASE_URl + '/ban', element);
  }

  public unban(element: UserBan) {

    return this.http.post(BASE_URl + '/unban' , element);
  }

  public delete(element: UserBan) {
    return this.http.post(BASE_URl + '/delete' , element);
  }

  public changeAdmin(element: UserBan) {
    return this.http.post(BASE_URl + '/make-admin' , element);
  }

  public forbidReservation(userBan:UserBan){
    return this.http.post(ForbiddenUserURL,userBan);
  }

  public forbidCreation(userBan:UserBan){
    return this.http.post(ForbiddenUserURL+"/creation",userBan);
  }
}
