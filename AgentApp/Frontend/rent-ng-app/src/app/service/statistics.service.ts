import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Price} from '../model/price';
import {Statistics} from '../model/statistics';

const BASE_URL = environment.statistics;
@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http: HttpClient) { }

  public getStatistics(): Observable<Statistics[]>{
    return this.http.get<Statistics[]>(BASE_URL + 'statistics');
  }
}
