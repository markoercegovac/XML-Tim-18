import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CartransmissionType} from '../model/cartransmission-type';
import {Observable} from 'rxjs';
import {CarFuelType} from '../model/car-fuel-type';

@Injectable({
  providedIn: 'root'
})
export class CarFuelTypeService {
  private URL: string;
  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:9090/crud';
  }

  public createFt(ft: CarFuelType){
    return this.http.post<CarFuelType>(this.URL + '/createFT', ft);
  }
  public updateFt(ft: CarFuelType, id: number){
    return this.http.post<CarFuelType>(this.URL + '/updateFT/' + id , ft);
  }
  public deleteFt(id: number, ft: CarFuelType){
    return this.http.post<CarFuelType>(this.URL + '/deleteFT/' + id, ft);
  }
  public readFt(): Observable<CarFuelType[]>{
    return this.http.get<CarFuelType[]>(this.URL + '/readFT');
  }
  public readFtById(id: number): Observable<any>{
    return this.http.get<any>(this.URL + '/readFT/' + id );
  }
}
