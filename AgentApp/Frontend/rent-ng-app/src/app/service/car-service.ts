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
import {environment} from '../../environments/environment';
import {CarMini} from '../model/car-mini';

const URL = environment.car;

@Injectable({
  providedIn: 'root'
})

export class CarService {


  constructor(private http: HttpClient) {

  }

  public getAllCarModels(): Observable<CarModel[]> {
    return this.http.get<CarModel[]>(URL + '/allModels');
  }

  public getAllCarBrands(): Observable<CarBrand[]>{
    return this.http.get<CarBrand[]>(URL + '/allBrands');
  }

  public getAllCarTransmissionType(): Observable<CarTransmission[]>{
    return this.http.get<CarTransmission[]>(URL + '/allTransmissionType');
  }

  public getAllCarClass(): Observable<CarClass[]>{
    return this.http.get<CarClass[]>(URL + '/allCarClass');
  }

  public getAllFuelType(): Observable<CarFuelType[]>{
    return this.http.get<CarFuelType[]>(URL + '/allFuelType');
  }

  public registerCar(car: Car){
    return this.http.post(URL + '/registerCar', car);
  }

  public getAllCars(): Observable<CarMini[]>{
    return this.http.get<CarMini[]>(URL + '/allCars');
  }

}

