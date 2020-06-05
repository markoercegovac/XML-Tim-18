import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class CarFuelTypeService {


  constructor(public http: HttpClient) {

  }

  public getAllCarFuelType() {
    const url = 'http://localhost:9090//advert-manager/car-fuel-type/all';
    return this.http.get<any>(url);
  }
}
