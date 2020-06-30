import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';

const BASE_URL = environment.zuul;

@Injectable({providedIn: 'root'})
export class TestService {

    constructor(private http: HttpClient) {}

    public test() {
        return this.http.get("http://localhost:8662/comment-manager/test");
    }

}
