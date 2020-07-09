import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { UserRegistrationModel } from '../model/user-registration.model';

const BASE = environment.zuul;

@Injectable({providedIn: 'root'})
export class RegistrationUserService {

	constructor(
		private http: HttpClient
	) {}

	register(user: UserRegistrationModel) {
		let url = BASE + '/user-manager/user';
		this.http.post(url, user, {responseType: 'text'}).subscribe(
			data => {
				alert('SUCCESSFULY REQISTRATED');
			}, error => {
				alert('SERER NOT RESPONDING, PLEASE TRY LATER');
			}
		);
	}
}