import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {MessageModel} from '../model/message-model';
import {MessageService} from '../service/message-service';
import {UserRegister} from '../model/UserRegister';
import {ClientService} from '../service/client-service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})



export class ChatComponent implements OnInit {

  allOwners: UserRegister[];

  constructor(private messageService: MessageService, private clientService: ClientService) { }

  ngOnInit(): void {
    this.clientService.getAllAcceptedOwnersEmails().subscribe(
      data => {
        this.allOwners = data;
        console.log(this.allOwners);
      }
    );
  }


  sendMessage(form: NgForm) {
    let message: MessageModel;
    message = {date: new Date(), id: null, title: form.value.titleInput, content: form.value.contentInput, recipient: form.value.recipientInput, sender: form.value.senderInput};
    this.messageService.sendMessage(message).subscribe();
    alert("Message Sent");
  }
}
