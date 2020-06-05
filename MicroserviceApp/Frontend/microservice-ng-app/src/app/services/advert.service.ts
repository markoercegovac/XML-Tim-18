import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AdvertDetailViewModel } from '../model/advert-detail-view.model';
import { advert_manager } from 'src/environments/environment';

const BASE_URL = advert_manager.apiUrl;

@Injectable({providedIn: 'root'})
export class AdvertService {

    constructor(private http: HttpClient) {}

    public getAdvertDetail(adId: number) {
        return this.http.get<AdvertDetailViewModel>(BASE_URL+'/advert/'+adId+'?details=client');
    }
}