import { Component, OnInit, Input } from '@angular/core';
import { CommentModel } from 'src/app/model/comment.model';
import { CommentService } from 'src/app/service/comment.service';

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

  constructor(private rest: CommentService) { }

  ngOnInit(): void {
    this.showAddCommentModal = false;


    if(this.adId != null) {
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
