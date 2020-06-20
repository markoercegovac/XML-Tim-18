import { Component, OnInit } from '@angular/core';
import {MessageModel} from '../model/message-model';


@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit {

  messages: MessageModel[] = [];

  constructor() { }

  ngOnInit(): void {
    this.mock();
  }

  mock() {
    this.messages.push({id: 1, title: 'TIM-18', content: 'Sve oce to da se ispisae', sender: 'erceg', recipient: 'er', date: null});

  }
}
