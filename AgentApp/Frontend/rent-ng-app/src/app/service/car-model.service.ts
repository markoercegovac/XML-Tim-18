import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import { environment } from 'src/environments/environment';

const BASE_URL = environment.car_model;

@Injectable({providedIn: 'root'})
export class CarModelService {


  constructor(public http: HttpClient) {
  }

  public getAllCarModel() {
    const url = BASE_URL + '/all';
    return this.http.get<any>(url);
  }
}
