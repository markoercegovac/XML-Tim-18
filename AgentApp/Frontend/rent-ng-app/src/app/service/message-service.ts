import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Car} from '../model/car';
import {MessageModel} from '../model/message-model';
import {Observable} from 'rxjs';
import {CommentModel} from '../model/comment.model';
import {CarModel} from '../model/carModel';

const URL = environment.message;

@Injectable({
  providedIn: 'root'
})

export class MessageService {
  constructor(private http: HttpClient) {
  }

  public sendMessage(message: MessageModel){
    return this.http.post(URL , message);
  }


  public getInbox(): Observable<MessageModel[]> {
    return this.http.get<MessageModel[]>(URL + '/inbox');
  }
  public getSent(): Observable<MessageModel[]> {
    return this.http.get<MessageModel[]>(URL + '/sent');
  }


}
