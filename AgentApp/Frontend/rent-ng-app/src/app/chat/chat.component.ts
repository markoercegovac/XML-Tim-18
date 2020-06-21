import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {MessageModel} from '../model/message-model';
import {MessageService} from '../service/message-service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  constructor(private messageService: MessageService) { }

  ngOnInit(): void {

  }


  sendMessage(form: NgForm) {
    let message: MessageModel;
    message = {date: new Date(), id: null, title: form.value.titleInput, content: form.value.contentInput, recipient: form.value.recipientInput, sender: form.value.senderInput};
    console.log(message);
    this.messageService.sendMessage(message).subscribe();
  }
}
