import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Comment} from '../model/Comment';

@Injectable({providedIn: 'root'})
export class CommentService {

  constructor(private http: HttpClient) {


  }

  public createComment(comment: Comment) {

    const url = 'http://localhost:8080/comment-manager/comment';

    return this.http.post(url, comment);
  }
}
