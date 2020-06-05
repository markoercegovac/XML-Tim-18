import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CarModel} from "../model/carModel";
import {CarBrand} from "../model/carBrand";
import {CarClass} from "../model/carClass";
import {CarFuelType} from "../model/carFuelType";
import {CarTransmission} from "../model/carTransmission";
import {Car} from "../model/car";
import {Price} from "../model/price";

@Injectable({
  providedIn: 'root'
})
export class CarService {
  private URL: string;

  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:9090/advert-manager';
  }

  public getAllCarModels(id: number): Observable<CarModel[]> {
    return this.http.get<CarModel[]>(this.URL + '/car-model/all/v2/'+id);
  }

  public getAllCarBrands(): Observable<CarBrand[]>{
    return this.http.get<CarBrand[]>(this.URL+'/car-brand/all/v2');
  }

  public getAllCarTransmissionType(): Observable<CarTransmission[]>{
    return this.http.get<CarTransmission[]>(this.URL+'/car-transmission/all/v2');
  }

  public getAllCarClass():Observable<CarClass[]>{
    return this.http.get<CarClass[]>(this.URL+'/car-class/all/v2');
  }

  public getAllFuelType():Observable<CarFuelType[]>{
    return this.http.get<CarFuelType[]>(this.URL+'/car-fuel-type/all/v2');
  }

  public registerCar(car:Car){
    return this.http.post(this.URL+'/car',car);
  }
  public  getUserCarList() : Observable<Car[]>{
    return this.http.get<Car[]>(this.URL+'/car/all');
  }

}
