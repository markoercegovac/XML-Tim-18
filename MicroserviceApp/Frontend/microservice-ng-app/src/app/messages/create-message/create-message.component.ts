import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { MessageService } from 'src/app/services/message.service';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { MessageCreateModel } from '../../model/message-create.model';

@Component({
  selector: 'app-create-message',
  templateUrl: './create-message.component.html',
  styleUrls: ['./create-message.component.css']
})
export class CreateMessageComponent implements OnInit {

  @Input('predefined') predefined: {header: string, receiver: string};
  @Output('seeInbox') seeInbox = new EventEmitter();
  contacts: string[];
  receiver: string;
  header: string;
  me: string;

  constructor(private route: ActivatedRoute, private msgService: MessageService) { }

  ngOnInit(): void {
    this.me = this.route.snapshot.params['email'];

    this.msgService.getListOfUsersForCommunication(this.me, true).subscribe(
      data => {
        this.contacts = data;
      }
    );

    if(this.predefined != null) {
      this.receiver = this.predefined.receiver;
      this.header = this.predefined.header;
    }
  }

  onSubmit(form: NgForm) {
    let msg: MessageCreateModel = {
      content: form.value.contentInput,
      header: form.value.headerInput,
      receiverEmail: this.receiver,
      senderEmail: this.me,
      isOwnerSending: true
    };

    this.msgService.sendMessage(msg).subscribe();

    this.seeInbox.emit();
  }

}
