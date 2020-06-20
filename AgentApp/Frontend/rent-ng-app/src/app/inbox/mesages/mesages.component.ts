import {Component, Input, OnInit} from '@angular/core';

import {MessageModel} from '../../model/message-model';
@Component({
  selector: 'app-mesages',
  templateUrl: './mesages.component.html',
  styleUrls: ['./mesages.component.css']
})
export class MesagesComponent implements OnInit {

  @Input("ms")message: MessageModel

  constructor() { }

  ngOnInit(): void {
  }

}
