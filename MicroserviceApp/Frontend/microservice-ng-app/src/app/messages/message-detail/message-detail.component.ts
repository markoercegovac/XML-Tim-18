import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { MessageDetailModel } from 'src/app/model/message-detail.model';
import { MessageService } from 'src/app/services/message.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-message-detail',
  templateUrl: './message-detail.component.html',
  styleUrls: ['./message-detail.component.css']
})
export class MessageDetailComponent implements OnInit {

  @Input('messageId') msgId: number;
  @Output('replay') replay = new EventEmitter<{header: string, receiver: string}>();
  msg: MessageDetailModel;
  amISender: boolean;
  error: boolean;

  constructor(private route: ActivatedRoute, private msgService: MessageService) { }

  ngOnInit(): void {
    let activeEmail = this.route.snapshot.params['email'];
    
    this.error = false;
    this.msgService.getDetailMessage(this.msgId).subscribe(
      data => {
        this.msg = data;
        this.amISender = activeEmail === this.msg.senderEmail;
      }, error => {
        this.error = true;
      });
  }

  onSend() {
    let rec = this.amISender?this.msg.receiverEmail:this.msg.senderEmail;
    this.replay.emit({header: this.msg.header, receiver: rec});
  }

}
