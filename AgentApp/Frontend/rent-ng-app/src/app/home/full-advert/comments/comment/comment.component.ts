import { Component, OnInit, Input } from '@angular/core';

import { CommentModel } from '../../../../model/comment.model';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html'
})
export class CommentComponent implements OnInit {

  @Input() comment: CommentModel;

  constructor() { }

  ngOnInit(): void {
  }

}
