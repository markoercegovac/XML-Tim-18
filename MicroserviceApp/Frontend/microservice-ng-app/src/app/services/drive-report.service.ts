import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {DriveReport} from '../model/DriveReport';

const report: string = environment.advertManagerUrl;
@Injectable({
  providedIn: 'root'
})
export class DriveReportService {

  constructor(private http: HttpClient) {}

  public createDr(dr: DriveReport){
    return this.http.post<DriveReport>(report + '/createDR', dr);
  }

  public readDrById(id: number): any{
    return this.http.get(report + '/readDR/' + id );
  }

  public getAllCars(): any{
    return this.http.get(report + '/allCars' );
  }
}
