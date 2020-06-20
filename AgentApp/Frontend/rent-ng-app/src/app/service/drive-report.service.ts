import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DriveReport} from '../model/drive-report';


@Injectable({
  providedIn: 'root'
})
export class DriveReportService {
  private URL: string;
  constructor(private http: HttpClient) {
    this.URL = 'http://localhost:9090/crud';
  }
  public createDr(dr: DriveReport){
    return this.http.post<DriveReport>(this.URL + '/createDR', dr);
  }
  public updateDr(dr: DriveReport, id: number){
    return this.http.post<DriveReport>(this.URL + '/updateDR/' + id , dr);
  }
  public deleteDr(id: number, dr: DriveReport){
    return this.http.post<DriveReport>(this.URL + '/deleteDR/' + id, dr);
  }
  public readDr(): Observable<DriveReport[]>{
    return this.http.get<DriveReport[]>(this.URL + '/readDR');
  }
  public readDrById(id: number): Observable<any>{
    return this.http.get<any>(this.URL + '/readDR/' + id );
  }
}
