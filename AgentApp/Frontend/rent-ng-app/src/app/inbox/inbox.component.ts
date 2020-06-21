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
  change: boolean;

  constructor(private messageService: MessageService) { }

  ngOnInit(): void {
    this.change=true;
    this.changeUser();
  }


  changeUser() {

    if (this.change == true){
      this.change = false;
      this.loadUser(this.change);
    }
    else {
      this.change = true;
      this.loadUser(this.change);
    }
  }

  loadUser(change: boolean){
    if(change){
      this.messageService.getInbox().subscribe(
        data=>{
          this.messages = data;
        }
      );
    }
    else {
      this.messageService.getInboxTest().subscribe(
        data=>{
          this.messages=data;
        }
      );
    }
  }
}
