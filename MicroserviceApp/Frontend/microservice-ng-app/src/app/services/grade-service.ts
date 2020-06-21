import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Grade} from "../model/Grade";


@Injectable({providedIn: 'root'})

export class GradeService {

  constructor(private http: HttpClient) {


  }

  public createGrade(grade: Grade) {
    const url = 'http://localhost:8080/comment-manager/grade';

    return this.http.post(url, grade);
  }
}
