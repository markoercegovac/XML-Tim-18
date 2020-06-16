import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { environment } from 'src/environments/environment';

const BASE_URL = environment.advertManagerUrl;

@Injectable({providedIn: 'root'})
export class CarBrandService {


  constructor(private http: HttpClient) {


  }
  public getAllCarBrand() {
    const url = BASE_URL+'/car-brand/all';
    return this.http.get<any>(url);
  }

}
