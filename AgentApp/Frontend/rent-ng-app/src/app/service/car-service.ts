/* tslint:disable:no-trailing-whitespace */
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Car} from '../model/car';
import {CarModel} from "../model/carModel";
import {CarBrand} from "../model/carBrand";
import {CarClass} from "../model/carClass";
import {CarFuelType} from "../model/carFuelType";
import {CarTransmission} from "../model/carTransmission";

@Injectable({
  providedIn: 'root'
})

export class CarService {
  private URL: string;

  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:9090/api/car';
  }

  public getAllCarModels(): Observable<CarModel[]> {
    return this.http.get<CarModel[]>(this.URL + '/allModels');
  }

  public getAllCarBrands(): Observable<CarBrand[]>{
    return this.http.get<CarBrand[]>(this.URL+'/allBrands');
  }

  public getAllCarTransmissionType(): Observable<CarTransmission[]>{
    return this.http.get<CarTransmission[]>(this.URL+'/allTransmissionType');
  }

  public getAllCarClass():Observable<CarClass[]>{
    return this.http.get<CarClass[]>(this.URL+'/allCarClass');
  }

  public getAllFuelType():Observable<CarFuelType[]>{
    return this.http.get<CarFuelType[]>(this.URL+'/allFuelType');
  }

  public registerCar(car:Car){
    return this.http.post(this.URL+'/registerCar',car);
  }

}

