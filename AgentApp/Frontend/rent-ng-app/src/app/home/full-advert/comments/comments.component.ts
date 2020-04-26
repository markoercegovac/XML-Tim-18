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
  comments: CommentModel[] = [];

  constructor() { }

  ngOnInit(): void {
    if(this.adId===2) {
      this.mock();
    }
  }

  onAddComment() {
    alert('ADDING NEW COMMENT');
  }

  mock() {
    this.comments.push({author: 'mika', content: 'super je!'});
    this.comments.push({author: 'pera', content: 'odlicno!'});
    this.comments.push({author: 'djura', content: 'pali iz prve'});
  }

}
