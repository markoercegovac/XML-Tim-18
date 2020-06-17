import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { AdvertCreateModel } from '../model/advert-create.model';
import { environment } from 'src/environments/environment';
import { AdvertFullModel } from '../model/advert-full.model';

const BASE_URL = environment.http+'/api/advert'

@Injectable({providedIn: 'root'})
export class AdvertService {

	constructor(private http: HttpClient) {}

	public createAd(ad) {
		return this.http.post(BASE_URL, ad, {responseType: 'text',});
	}

	public getAdvert(id: number) {
		return this.http.get(BASE_URL+'/'+id);
	}
}