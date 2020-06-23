import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {AdvertCreateModel} from '../model/advert-create.model';
import {Observable} from 'rxjs';
import {Price} from '../model/price';
import {AdvertMiniComponent} from '../home/adverts/advert-mini/advert-mini.component';
import {AdvertMiniModel} from '../model/advert-mini.model';
import {Reservation} from '../model/reservation';

const URL: string = environment.advert;
const priceURL: string = environment.price;
const gradeUrl: string = environment.grade;
@Injectable({
  providedIn: 'root'
})

export class AdvertService {

  public advertList: AdvertMiniModel[];

  constructor(private http: HttpClient) {
  }

  public createAdvert(advert: AdvertCreateModel){
    return this.http.post(URL, advert);
  }

  public getAllPrices(): Observable<Price[]>{
    return this.http.get<Price[]>(priceURL + '/allPrices');
  }


  public getAllAdverts(): Observable<AdvertMiniModel[]> {
     return this.http.get<AdvertMiniModel[]>(URL + '/allAdverts');

  }

  public allReservationForAdvert(id: number): Observable<Reservation[]>{
    return this.http.get<Reservation[]>(URL + '/reservation/' + id);
  }

  public createReservation(capture: Reservation){
    return this.http.post(URL + '/reservation', capture);
  }
  public getGradeForAdvert(id: number): any{
    return this.http.get(gradeUrl + '/all/' + id);
  }

  public getAdvert(id: number): any{
    return this.http.get(URL + '/show/' + id);
  }
}
