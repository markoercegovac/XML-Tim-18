import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private url = 'http://localhost:9090/search-manager/';
  constructor(private http: HttpClient) { }

  searchOglase(city: string, startOfAdvert: string, endOfAdvert: string) {


    // @ts-ignore
    return this.http.post(this.url + 'search/' + city + '/' + startOfAdvert + '/' + endOfAdvert);

  }

}
