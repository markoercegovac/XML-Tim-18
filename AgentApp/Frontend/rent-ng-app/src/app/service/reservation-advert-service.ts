import {NgModule,Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {AdvertReservationReq} from '../model/AdvertReservationReq';

const URL: string = environment.advert_request;

@Injectable({
  providedIn: 'root'
})

export class ReservationAdvertService {


  constructor(private http: HttpClient) {
  }

  public saveAdvertRequest(AdvertRequest: AdvertReservationReq) {
    return this.http.post(URL, AdvertRequest);
  }

}
