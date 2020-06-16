import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';

const BASE_URL = environment.searchManagerUrl;

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  searchOglase(city: string, startOfAdvert: string, endOfAdvert: string) {


    //FALI BODY OD POST METODE
    // @ts-ignore
    return this.http.post(BASE_URL + 'search/' + city + '/' + startOfAdvert + '/' + endOfAdvert);

  }

}
