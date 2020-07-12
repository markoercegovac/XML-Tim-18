import {CommentModel} from '../model/comment.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private BASE_URL = 'http://localhost:8662/comment-manager/all/';

  constructor(private http: HttpClient) { }

  public getAllCommentsForAd(adId: number): any {
    return this.http.get<any>(this.BASE_URL + adId);
  }
}
