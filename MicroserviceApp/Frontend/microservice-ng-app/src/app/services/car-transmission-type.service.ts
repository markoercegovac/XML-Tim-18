import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import { environment } from 'src/environments/environment';

const BASE_URL = environment.advertManagerUrl;

@Injectable({providedIn: 'root'})
export class CarTransmissionTypeService {


  constructor(public http: HttpClient) {
  }

  public getAllCarTranssmisionType() {
    const url = BASE_URL+'/car-transmission/all';
    return this.http.get<any>(url);

  }
}
