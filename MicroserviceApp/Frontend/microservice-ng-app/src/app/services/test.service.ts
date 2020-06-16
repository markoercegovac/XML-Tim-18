import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';

const BASE_URL = environment.localhost;

@Injectable({providedIn: 'root'})
export class TestService {

    constructor(private http: HttpClient) {}

    public test() {
        return this.http.get(BASE_URL+'/user-manager/test');
    }

}