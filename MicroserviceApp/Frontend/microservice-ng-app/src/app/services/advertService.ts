import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Advert} from "../model/advert";
import {templateSourceUrl} from "@angular/compiler";
import {Observable} from "rxjs";
import {CarFuelType} from "../model/carFuelType";
import {Capture} from "../model/capture";
import { environment } from 'src/environments/environment';
import {AdvertMiniModel} from "../model/advert-mini.model";

// const URL: string= environment.advertManagerUrl+'/advert'
const URL: string= environment.zuul+'/advert-manager/advert'

@Injectable({
  providedIn: 'root'
})

export class AdvertService{
  constructor(private http: HttpClient) {

  }

  public createAdvert(advert: Advert){
    return this.http.post(URL,advert,{responseType: "text"});
  }

  public getAllAdverts():Observable<Advert[]>{
    return this.http.get<Advert[]>(URL+'/all');
  }

  public getAllCaptureForAdvert(id: number):Observable<Capture[]>{
    return this.http.get<Capture[]>(URL+'/capture/'+id);
  }
  public createCaptureForAdvert(capture:Capture){
    return this.http.post(URL+'/capture',capture);
  }

  public homeAllAdvert():Observable<AdvertMiniModel[]>{
    return this.http.get<AdvertMiniModel[]>(URL+'/home/all');
  }



}


