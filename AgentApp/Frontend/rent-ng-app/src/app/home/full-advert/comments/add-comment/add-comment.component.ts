import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms'

@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styles: [
  ]
})
export class AddCommentComponent implements OnInit {

  @Input('ad-id') adId: number;
  constructor() { }

  ngOnInit(): void {
  }

  onAddComment(form: NgForm) {
    let content = form.value.contentInput;

    alert(this.adId+ ' content '+ content);
  }

}
