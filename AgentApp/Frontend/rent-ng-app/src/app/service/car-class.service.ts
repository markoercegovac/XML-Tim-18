import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import { environment } from 'src/environments/environment';

const BASE_URL = environment.car_class;

@Injectable({providedIn: 'root'})
export class CarClassService {

  constructor(public http: HttpClient) {
  }


  public getAllCarClass() {
    const url = BASE_URL + '/all';
    return this.http.get<any>(url);
  }
}
