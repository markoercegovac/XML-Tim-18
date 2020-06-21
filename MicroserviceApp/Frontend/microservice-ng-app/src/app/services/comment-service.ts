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

  public getAllNewRequest() {

    const urlGet = 'http://localhost:8080/comment-manager/comment/get-new';

    return this.http.get<any>(urlGet);
  }

  public approved(comment: Comment) {

    const urlApproved = 'http://localhost:8080/comment-manager/comment/approved';

    return this.http.post(urlApproved, comment);
  }

  public rejected(comment: Comment) {

    const urlRejected = 'http://localhost:8080/comment-manager/comment/rejected';

    return this.http.post(urlRejected, comment);

  }
}
