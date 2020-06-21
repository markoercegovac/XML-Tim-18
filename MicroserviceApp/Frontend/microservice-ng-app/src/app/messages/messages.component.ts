import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MessageItemModel } from '../model/message-item.model';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  messages: MessageItemModel[];
  activeEmail: string;
  messageId: number;

  showBody: string;
  bodyEnum: string[] = ['inbox', 'compose', 'detail'];

  constructor(private route: ActivatedRoute, private msgService: MessageService) { }

  ngOnInit(): void {
    this.messageId = 0;
    this.showBody = this.bodyEnum[0];
    this.activeEmail = this.route.snapshot.params['email'];

    this.reload();
  }

  onToggle() {
    this.reload();
    if(this.showBody === this.bodyEnum[0]) {
      this.showBody = this.bodyEnum[1];
    } else {
      this.showBody = this.bodyEnum[0];
    }
  }

  detailView(msgId: number) {
    this.messageId = msgId;
    this.showBody = this.bodyEnum[2];
  }

  replay(event) {
    alert()
  }

  reload() {
    this.msgService.getAllMessages(this.activeEmail, true).subscribe(
      data => {
        this.messages = data;
      }, error => {
        alert("BAD EMAIL");
      }
    )
  }

}
