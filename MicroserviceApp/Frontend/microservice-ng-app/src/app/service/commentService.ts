import {CommentModel} from '../model/comment.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private BASE_URL = 'http://localhost:9090/comment/';

  constructor(private http: HttpClient) { }

  public getAllCommentsForAd(adId: number): Observable<any> {
    return this.http.get<CommentModel[]>(this.BASE_URL + adId);
  }
}
