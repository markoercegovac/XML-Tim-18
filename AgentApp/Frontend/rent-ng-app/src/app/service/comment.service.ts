import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { CommentModel } from '../model/comment.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private BASE_URL: string = 'http://localhost:9090/comment/';

  constructor(private http: HttpClient) { }

  public getAllCommentsForAd(adId: number): Observable<any> {
    return this.http.get<CommentModel[]>(this.BASE_URL+adId);
  }
}
