import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegistrationRequestModel } from '../model/registretion-request.model';
import { environment } from 'src/environments/environment';

const BASE = environment.zuul;

@Injectable({providedIn: 'root'})
export class RegistrationRequestsService {

	constructor(
		private http: HttpClient
	) {}

	getAllRequests() {
		let url = BASE + '/admin/user-manager/registration-request';
		return this.http.get<RegistrationRequestModel[]>(url);
	}

	bless(email: string) {
		let url = BASE + '/admin/user-manager/registration-request/' + email;
		this.http.put(url, email, {responseType: 'text'}).subscribe();
	}

	decline(email: string) {
		let url = BASE + '/admin/user-manager/registration-request/' + email;
		this.http.delete(url, {responseType: 'text'}).subscribe();
	}
}