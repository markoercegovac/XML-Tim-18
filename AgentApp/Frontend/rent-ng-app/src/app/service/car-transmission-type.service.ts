import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import { environment } from 'src/environments/environment';

const BASE_URL = environment.car_transsmision_type;

@Injectable({providedIn: 'root'})
export class CarTransmissionTypeService {


  constructor(public http: HttpClient) {
  }

  public getAllCarTranssmisionType() {
    const url = BASE_URL + '/all';
    return this.http.get<any>(url);

  }
}
