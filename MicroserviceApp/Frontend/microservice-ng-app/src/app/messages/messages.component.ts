import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MessageItemModel } from '../model/message-item.model';
import { MessageService } from '../services/message.service';
import { AuthService } from '../services/auth.service';

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
  predefinedMsg : {header: string, receiver: string};

  constructor(
    private route: ActivatedRoute,
    private msgService: MessageService,
    private auth: AuthService
    ) { }

  ngOnInit(): void {
    this.messageId = 0;
    this.showBody = this.bodyEnum[0];
    this.activeEmail = this.route.snapshot.params['email'];
    this.predefinedMsg = null;

    this.reload();
  }

  onToggle() {
    if(this.showBody === this.bodyEnum[0]) {
      this.predefinedMsg = null;
      this.showBody = this.bodyEnum[1];
    } else {
      this.showBody = this.bodyEnum[0];
      this.reload();
    }
  }

  detailView(msgId: number) {
    this.messageId = msgId;
    this.showBody = this.bodyEnum[2];
  }

  replay(event: {header: string, receiver: string}) {
    this.predefinedMsg = event;
    this.showBody = this.bodyEnum[1];
  }

  seeInbox() {
    this.reload();
    this.showBody = this.bodyEnum[0];
  }

  reload() {
    console.log('RELOAD MSG');
    this.msgService.getAllMessages(this.activeEmail, this.auth.getPermissions().includes('PERMISSION_OWNER')).subscribe(
      data => {
        this.messages = data;
      }, error => {
        alert("BAD EMAIL");
      }
    )
  }

}
