import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {AdvertCreateModel} from '../model/advert-create.model';
import {Observable} from 'rxjs';
import {Price} from '../model/price';

const URL: string = environment.advert;
const priceURL: string = environment.price;

@Injectable({
  providedIn: 'root'
})

export class AdvertService {
  constructor(private http: HttpClient) {
  }

  public createAdvert(advert: AdvertCreateModel){
    return this.http.post(URL,advert);
  }

  public getAllPrices(): Observable<Price[]>{
    return this.http.get<Price[]>(priceURL+'/allPrices');
  }
}
