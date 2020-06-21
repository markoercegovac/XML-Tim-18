import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DriveReport} from '../model/drive-report';
import {environment} from '../../environments/environment';

const report: string = environment.report;
@Injectable({
  providedIn: 'root'
})
export class DriveReportService {

  constructor(private http: HttpClient) {}
  public createDr(dr: DriveReport){
    return this.http.post<DriveReport>(report + '/createDR', dr);
  }
  public updateDr(dr: DriveReport, id: number){
    return this.http.post<DriveReport>(report + '/updateDR/' + id , dr);
  }
  public deleteDr(id: number, dr: DriveReport){
    return this.http.post<DriveReport>(report + '/deleteDR/' + id, dr);
  }
  public readDr(): Observable<any>{
    return this.http.get<any>(report + '/readDR');
  }
  public readDrById(id: number): Observable<any>{
    return this.http.get<any>(report + '/readDR/' + id );
  }
}
