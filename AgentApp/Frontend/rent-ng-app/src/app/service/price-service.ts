import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Price} from '../model/price';
import {environment} from '../../environments/environment';
const priceURL: string = environment.price;
@Injectable({
  providedIn: 'root'
})

export class PriceService{


  constructor(private http: HttpClient) {

  }
  public createPrice(price: Price){
    return this.http.post(priceURL, price);
  }
}
