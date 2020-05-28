import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';

const BASE_URL = 'http://localhost:8081';

@Injectable({providedIn: 'root'})
export class TestService {

    constructor(private http: HttpClient) {}

    public test() {
        return this.http.get(BASE_URL+'/user-manager/test');
    }

}