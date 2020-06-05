import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class CarClassService {

  constructor(public http: HttpClient) {
  }


  public getAllCarClass() {
    const url = 'http://localhost:9090/advert-manager/car-class/all';
    return this.http.get<any>(url);
  }
}
