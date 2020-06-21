import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { MessageItemModel } from '../model/message-item.model';
import { MessageDetailModel } from '../model/message-detail.model';
import { MessageCreateModel } from '../model/message-create.model';

const BASE_URL = environment.chatManagerUrl;

@Injectable({providedIn: 'root'})
export class MessageService {

	constructor(private http:HttpClient) {}

	public getAllMessages(email: string, isOwner: boolean) {
		let url: string = BASE_URL+'/message/'+email+"?owner="+isOwner;
		return this.http.get<MessageItemModel[]>(url);
	}

	public getDetailMessage(id: number) {
		let url: string = BASE_URL+'/message/detail/'+id;
		return this.http.get<MessageDetailModel>(url);
	}

	public getListOfUsersForCommunication(email: string, isOwner: boolean) {
		let url: string = BASE_URL+'/message/'+email+"/can-communicate?owner="+isOwner;
		return this.http.get<string[]>(url);
	}

	public sendMessage(msg: MessageCreateModel) {
		let url: string = BASE_URL+'/message';
		return this.http.post(url, msg, {responseType: 'text'});
	}
}