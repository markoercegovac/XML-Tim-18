import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { CommentModel } from '../model/comment.model';
import { Observable } from 'rxjs';
import {environment} from '../../environments/environment';


const commUrl: string = environment.comm;
@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  public createComment(comment: CommentModel){
    return this.http.post(commUrl + 'add', comment);
  }

  public getAllCommentsForAd(adId: number): any{
    return this.http.get(commUrl + adId);
  }
}
