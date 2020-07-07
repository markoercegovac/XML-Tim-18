import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ClientCopy} from "../model/ClientCopy";
import {environment} from "../../environments/environment";
import {UserBan} from "../model/UserBan";


// @ts-ignore
@Injectable({providedIn: 'root'})

const BASE_URL = environment.zuul+'/advert-manager';

export class ClientCopyService {
  constructor(private http: HttpClient) {
  }


}
