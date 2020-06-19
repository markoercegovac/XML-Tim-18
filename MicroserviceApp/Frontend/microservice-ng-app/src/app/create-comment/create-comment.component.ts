import { Component, OnInit } from '@angular/core';
import {Comment} from '../model/Comment';
import {Grade} from "../model/Grade";
import {HttpClient} from "@angular/common/http";
import {GradeService} from "../service/grade-service";
import {CommentService} from "../service/comment-service";
import {error} from "@angular/compiler/src/util";
@Component({
  selector: 'app-create-comment',
  templateUrl: './create-comment.component.html',
  styleUrls: ['./create-comment.component.css']
})
export class CreateCommentComponent implements OnInit {




  grade: Grade = {
    grade: null
  };
// ne zaboravi da si setovala id =1 zbog hardkodovanja trenutnoo!
  comment: Comment = {
    advertId: 1,
    userEmail: '',
    header: '',
    content: ''
  };

  stars: number[] = [1, 2, 3, 4, 5];

  constructor(public http: HttpClient , public gradeService: GradeService,
              public commentService: CommentService) { }

  ngOnInit(): void {
  }


  public countStar(star) {
    this.grade.grade = star;
    console.log('Value of star', star);
  }

  public kreirajKomentarIOcenu() {


    this.gradeService.createGrade(this.grade).subscribe(res => {

    },
      error => {
      alert("Problem with rating the advert.");
      });

    this.commentService.createComment(this.comment).subscribe(res=>{
      alert("Comment is successfuly send to administrator.He needs to aprove it.Thanks for leaving comment :) ")
    },
      error=>{
      alert("Problem with sending comment or grade. Please try again.");

      });
  }
}
