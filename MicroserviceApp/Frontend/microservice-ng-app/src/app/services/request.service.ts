import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RequestBundleModel } from '../model/request-bundle.model';
import { environment } from '../../environments/environment'
import { AuthService } from './auth.service';
import { RequestDetailModel } from '../model/request-detail.model';

// const BASE_URL = environment.requestManagerUrl
const BASE_URL = environment.zuul + '/advert-request';
@Injectable({providedIn: 'root'})
export class RequestService {

	public bundles: RequestBundleModel[] = [];
	private lestState: string = null;

	constructor(
		private http: HttpClient,
		private auth: AuthService
	) {}

	public getBundles(state: string) {
		this.lestState = state;
		let owner = this.auth.getCurrentUserEmail();

		let url = BASE_URL+'/owner/'+owner;
		if(state !== 'ALL') {
			url += '?status='+state;
		}

		this.http.get<RequestBundleModel[]>(url).subscribe(
			data => {
				this.bundles = data;
			}, error => {
				this.bundles = [];
			}
			
		)
	}

	public cancelBundle(bundleId: number) {
		this.http.delete(BASE_URL+'/'+bundleId, {responseType: 'text'}).subscribe(
			data => {
				this.getBundles(this.lestState);
			}, error => {
				alert("SOMETHING WENT WRONG");
			}
		)
	}

	public approveBundle(bundleId: number) {
		this.http.put(BASE_URL+'/owner/'+bundleId, {}, {responseType: 'text'}).subscribe(
			data => {
				this.getBundles(this.lestState);
			}, error => {
				alert("SOMETHING WENT WRONG");
			}
		)
	}

	public getClientRequests() {
		let url = BASE_URL + '/client/' + this.auth.getCurrentUserEmail();

		return this.http.get<RequestDetailModel[]>(url);
	}
}