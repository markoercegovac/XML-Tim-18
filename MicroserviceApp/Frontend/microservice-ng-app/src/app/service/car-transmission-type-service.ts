import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class CarTransmissionTypeService {


  constructor(public http: HttpClient) {
  }

  public getAllCarTranssmisionType() {
    const url = 'http://localhost:9090/advert-manager/car-transmission/all';
    return this.http.get<any>(url);

  }
}
