import { Component, OnInit } from '@angular/core';
import {MessageModel} from '../model/message-model';
import {MessageService} from '../service/message-service';


@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit {

  messages: MessageModel[] = [];


  constructor(private messageService: MessageService) { }

  ngOnInit(): void {
    this.messageService.getInbox().subscribe(
      data=>{
        this.messages = data;
      }
    );
  }

}
