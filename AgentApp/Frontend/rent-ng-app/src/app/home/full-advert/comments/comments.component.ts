import { Component, OnInit, Input } from '@angular/core';
import { CommentModel } from 'src/app/model/comment.model';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styles: [
  ]
})
export class CommentsComponent implements OnInit {

  @Input('ad-id') adId: number;
  showAddCommentModal: boolean;
  comments: CommentModel[] = [];

  constructor() { }

  ngOnInit(): void {
    this.showAddCommentModal = false;
    if (this.adId === 1) {
      this.mock();
    }
  }

  onAddComment() {
    this.showAddCommentModal = !this.showAddCommentModal;
  }

  mock() {
    this.comments.push({ commentId: 1, author: 'mika', content: 'super je!', advertId: 1 });
    this.comments.push({ commentId: 2, author: 'pera', content: 'odlicno!', advertId: 1 });
    this.comments.push({ commentId: 3, author: 'djura', content: 'pali iz prve', advertId: 1 });
  }

}
