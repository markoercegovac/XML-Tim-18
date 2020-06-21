import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RequestBundleModel } from '../model/request-bundle.model';
import { environment } from '../../environments/environment'

const BASE_URL = environment.requestManagerUrl

@Injectable({providedIn: 'root'})
export class RequestService {

	public bundles: RequestBundleModel[] = [];
	private lestState: string = null;

	constructor(private http: HttpClient) {}

	public getBundles(state: string) {
		this.lestState = state;

		let url = BASE_URL+'/owner/pera@maildrop.cc';
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
}