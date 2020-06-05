import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class CarModelService {


  constructor(public http: HttpClient) {
  }

  public getAllCarModel() {
    const url = 'http://localhost:9090//advert-manager/car-model/all';
    return this.http.get<any>(url);
  }
}
