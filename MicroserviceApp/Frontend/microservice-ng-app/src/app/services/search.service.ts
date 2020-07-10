import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import {Observable} from 'rxjs';
import {Search} from '../model/search';
import {CarModelPomocna} from '../model/car-model-pomocna';
import {CarBrandPomocna} from '../model/car-brand-pomocna';
import {CarFuelTypePomocna} from '../model/car-fuel-type-pomocna';
import {CarTransmissionPomocna} from '../model/car-transmission-pomocna';
import {CarClassPomocna} from '../model/car-class-pomocna';


const BASE_URL = environment.searchManagerUrl;

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  searchOglase(city: string, startOfAdvert: string, endOfAdvert: string) {
    // @ts-ignore
    return this.http.post(BASE_URL + 'search/' + city + '/' + startOfAdvert + '/' + endOfAdvert);
  }

  getAllAdverts(): Observable<Search []> {
    // @ts-ignore
    return this.http.get<Search []>(BASE_URL + 'allAdverts');
  }

  // tslint:disable-next-line:max-line-length
  searchAdvancedAdverts(city: string, startOfAdvert: string, endOfAdverts: string, carMark: string, modelMark: string, carFuelType: string, carTransmissionType: string, carClass: string, priceFrom: string, priceTo: string, traveledKm: string, plannedKm: string, insurance: string, numberOfSeats: string, mark: string){
    // tslint:disable-next-line:max-line-length
    return this.http.post(BASE_URL + 'advancedAdverts/' + city + '/' + startOfAdvert + '/' + endOfAdverts + '/' + carMark + '/' + modelMark + '/' + carFuelType + '/' + carTransmissionType + '/' + carClass + '/' + priceFrom + '/' + priceTo + '/' + traveledKm + '/' + plannedKm + '/' + insurance + '/' + numberOfSeats + '/' + mark, null);
  }

  getAllMarks(): Observable<CarBrandPomocna []> {
    // @ts-ignore
    return this.http.get<CarBrandPomocna []>(BASE_URL + 'allMarks');
  }

  getAllModels(): Observable<CarModelPomocna []> {
    // @ts-ignore
    return this.http.get<CarModelPomocna []>(BASE_URL + 'allModels');
  }

  getAllFuelType(): Observable<CarFuelTypePomocna []> {
    // @ts-ignore
    return this.http.get<CarFuelTypePomocna []>(BASE_URL + 'allFuelType');
  }

  getAllTransmissionType(): Observable<CarTransmissionPomocna []> {
    // @ts-ignore
    return this.http.get<CarTransmissionPomocna []>(BASE_URL + 'allTransmissionType');
  }

  getAllClasses(): Observable<CarClassPomocna []> {
    // @ts-ignore
    return this.http.get<CarClassPomocna []>(BASE_URL + 'allClasses');
  }
}
