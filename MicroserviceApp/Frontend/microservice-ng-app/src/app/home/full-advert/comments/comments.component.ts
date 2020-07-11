import {Component, Input, OnInit} from '@angular/core';
import {CommentModel} from '../../../model/comment.model';
import {CommentService} from '../../../services/commentService';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  // tslint:disable-next-line:no-input-rename
  @Input('ad-id') adId: number;
  showAddCommentModal: boolean;
  comments: CommentModel[] = [];

  constructor(private rest: CommentService) { }

  ngOnInit(): void {
    this.showAddCommentModal = false;


    if ( this.adId != null) {
      this.getAllComennts(this.adId);
    }

  }

  onAddComment() {
    this.showAddCommentModal = !this.showAddCommentModal;
  }

  getAllComennts(adId: number) {
    this.rest.getAllCommentsForAd(adId).subscribe(
      (data: CommentModel[]) => {
        this.comments = data;
      }, (err) => {
        this.comments = [];
        console.log('no coment');
      }
    );
  }

}


