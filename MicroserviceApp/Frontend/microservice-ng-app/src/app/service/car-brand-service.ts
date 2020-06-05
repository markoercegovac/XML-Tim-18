import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CarBrand} from "../model/CarBrand";

@Injectable({providedIn: 'root'})
export class CarBrandService {


  constructor(private http: HttpClient) {


  }
  public getAllCarBrand() {
    const url = 'http://localhost:9090/advert-manager/car-brand/all';
    return this.http.get<any>(url);
  }

}
