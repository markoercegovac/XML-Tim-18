import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CartransmissionType} from '../model/cartransmission-type';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarTransmissionTypeService {

  private URL: string;
  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:9090/crud';
  }
  public createCtt(ctt: CartransmissionType){
    return this.http.post<CartransmissionType>(this.URL + '/createCTT', ctt);
}
  public updateCtt(ctt: CartransmissionType, id: number){
    return this.http.post<CartransmissionType>(this.URL + '/updateCTT/' + id , ctt);
  }
  public deleteCtt(id: number, ctt: CartransmissionType){
    return this.http.post<CartransmissionType>(this.URL + '/deleteCTT/' + id, ctt);
  }
  public readCtt(): Observable<CartransmissionType[]>{
    return this.http.get<CartransmissionType[]>(this.URL + '/readCTT');
  }
  public readCttById(id: number): Observable<any>{
    return this.http.get<any>(this.URL + '/readCTT/' + id );
  }
}
