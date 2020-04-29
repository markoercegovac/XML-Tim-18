import { Component, OnInit } from '@angular/core';
import { CommentForApproval } from 'src/app/model/commentForApproval';

@Component({
  selector: 'app-admin-comments',
  templateUrl: './admin-comments.component.html',
  styles: [
  ]
})
export class AdminCommentsComponent implements OnInit {

  comments: CommentForApproval[] = [];

  constructor() { }

  ngOnInit(): void {
    this.mock();
  }

  private mock(): void {
    this.comments.push({ advertId: 1, authorEmail: 'pera@maildrop.cc', commentId: 15, content: 'abcd', isApproved: false });
    this.comments.push({ advertId: 1, authorEmail: 'pera@maildrop.cc', commentId: 17, content: '!?', isApproved: false });
    this.comments.push({ advertId: 1, authorEmail: 'pera@maildrop.cc', commentId: 16, content: 'ahhh', isApproved: false });
  }

}
