import { Component, OnInit, Input } from '@angular/core';
import { CommentForApproval } from 'src/app/model/commentForApproval';

@Component({
  selector: 'app-admin-comment',
  templateUrl: './admin-comment.component.html',
  styles: [
  ]
})
export class AdminCommentComponent implements OnInit {

  @Input('comment') comment: CommentForApproval;

  constructor() { }

  ngOnInit(): void {
  }

}
