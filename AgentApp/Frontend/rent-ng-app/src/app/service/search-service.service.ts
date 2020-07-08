import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';

const BASE_URL = environment.searchUrl;

@Injectable({
  providedIn: 'root'
})
export class SearchServiceService {

  constructor(private http: HttpClient) { }

  searchOglase(city: string, startOfAdvert: string, endOfAdvert: string) {
    // @ts-ignore
    return this.http.post(BASE_URL + 'search/' + city + '/' + startOfAdvert + '/' + endOfAdvert, null);
  }
}
