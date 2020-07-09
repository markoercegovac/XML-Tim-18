import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegistrationAgentModel } from '../model/registration-agent.model';
import { environment } from 'src/environments/environment';

const BASE = environment.zuul;

@Injectable({providedIn: 'root'})
export class RegistrationAgentService {

	constructor(
		private http: HttpClient
	) {}

	register(agent: RegistrationAgentModel) {
		let url = BASE + '/user-manager/agent';
		this.http.post(url, agent, {responseType: 'text'}).subscribe(
			data => {
				alert('SUCCESSFULY REQISTRATED');
			}, error => {
				alert('SERER NOT RESPONDING, PLEASE TRY LATER');
			}
		);
	}
}