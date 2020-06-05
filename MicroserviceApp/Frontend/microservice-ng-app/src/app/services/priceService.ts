import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Price} from '../model/price';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class PriceService{
   private readonly URL: string;

  constructor(private http: HttpClient){
    this.URL = 'http://localhost:9090/advert-manager/price';
  }

  public createPrice(price: Price) {
    return this.http.post(this.URL, price);
    alert("Radi");
  }

  public  getUserPriceList() : Observable<Price[]>{
    return this.http.get<Price[]>(this.URL+'/all');
  }

}
