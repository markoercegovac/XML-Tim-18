import { Component, OnInit } from '@angular/core';
import { RequestService } from '../services/request.service';

@Component({
  selector: 'app-owner-view-requests',
  templateUrl: './owner-view-requests.component.html',
  styleUrls: ['./owner-view-requests.component.css']
})
export class OwnerViewRequestsComponent implements OnInit {

  constructor(public requestSerivice: RequestService) { }

  ngOnInit(): void {

    this.requestSerivice.getBundles("ALL");
  }

  onChangeState(event) {
    let status: string = event.target.value;
    this.requestSerivice.getBundles(status);
  }

}
