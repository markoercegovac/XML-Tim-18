import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { MessageItemModel } from 'src/app/model/message-item.model';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  @Input('message') message: MessageItemModel;
  @Input('odd') odd: number;
  @Output('detailView') detailView = new EventEmitter<number>();
  constructor() { }

  ngOnInit(): void {
  }

  onSelectMsg() {
    this.detailView.emit(this.message.messageId);
  }

}
