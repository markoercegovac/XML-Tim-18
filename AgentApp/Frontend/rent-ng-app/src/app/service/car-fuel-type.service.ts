import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import { environment } from 'src/environments/environment';

const BASE_URL = environment.car_fuel_type;

@Injectable({providedIn: 'root'})
export class CarFuelTypeService {


  constructor(public http: HttpClient) {

  }

  public getAllCarFuelType() {
    const url = BASE_URL+'/all';
    return this.http.get<any>(url);
  }
}
