import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AdvertDetailViewModel } from '../model/advert-detail-view.model';
import { environment } from 'src/environments/environment';

const BASE_URL = environment.advertManagerUrl;

@Injectable({providedIn: 'root'})
export class AdvertService {

    constructor(private http: HttpClient) {}

    public getAdvertDetail(adId: number) {
        return this.http.get<AdvertDetailViewModel>(BASE_URL+'/advert/'+adId+'?details=client');
    }
}