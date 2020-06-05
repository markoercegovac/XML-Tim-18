import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Advert} from "../model/advert";
import {templateSourceUrl} from "@angular/compiler";

const URL: string='http://localhost:9090/advert-manager/advert'

@Injectable({
  providedIn: 'root'
})

export class AdvertService{
  constructor(private http: HttpClient) {

  }

  public createAdvert(advert: Advert){
    return this.http.post(URL,advert,{responseType: "text"});
  }




}


