import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import {CommentModel} from '../../../../model/comment.model';
import {CommentService} from '../../../../service/comment.service';
import {error} from "@angular/compiler/src/util";

@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styles: [
  ]
})
export class AddCommentComponent implements OnInit {


  @Input('ad-id') adId: number;
  constructor(private commentService: CommentService) { }

  ngOnInit(): void {
  }

  onAddComment(form: NgForm) {
    const content = form.value.contentInput;
    let model: CommentModel;
    console.log(this.adId);
    model = new CommentModel(null, content, this.adId);

    this.commentService.createComment(model).subscribe(
      res => {
        location.reload();
      },
      // tslint:disable-next-line:no-shadowed-variable
      error => {
      alert('Error');
        }
        );
  }

}
