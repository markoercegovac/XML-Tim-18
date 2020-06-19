import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styles: [
  ]
})


export class FooterComponent implements OnInit {
  isActiveChat: boolean;
  constructor() { }

  ngOnInit(): void {
  }

  public showChat() {
    this.isActiveChat = true;
  }
  public closeChat(){
    this.isActiveChat = false;
  }
}
