import {Component, Input, OnInit} from '@angular/core';
import {Comment} from '../../../../model/Comment';
import {Grade} from "../../../../model/Grade";
import {HttpClient} from "@angular/common/http";
import {GradeService} from "../../../../service/grade-service";
import {CommentService} from "../../../../service/comment-service";
import {error} from "@angular/compiler/src/util";
@Component({
  selector: 'app-create-comment',
  templateUrl: './create-comment.component.html',
  styleUrls: ['./create-comment.component.css']
})
export class CreateCommentComponent implements OnInit {


  @Input('ad-id') adId: number;

  grade: Grade = {
    grade: null
  };

  comment: Comment = {
    advertId: null,
    userEmail: '',
    header: '',
    content: ''
  };

  stars: number[] = [1, 2, 3, 4, 5];

  constructor(public http: HttpClient , public gradeService: GradeService,
              public commentService: CommentService) { }

  ngOnInit(): void {
    this.comment.advertId = this.adId;
  }


  public countStar(star) {
    this.grade.grade = star;
    console.log('Value of star', star);
    console.log(this.comment.advertId);
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
