import { Component, OnInit } from '@angular/core';
import { RequestService } from 'src/app/services/request.service';
import { RequestDetailModel } from 'src/app/model/request-detail.model';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {

  myRequests: RequestDetailModel[] = [];

  constructor(
    private requestService: RequestService
  ) { }

  ngOnInit(): void {
    this.requestService.getClientRequests().subscribe(
      data => {
        this.myRequests = data;
      }, error => {
        alert('SERVER NOT RESPONDING');
      }
    );
  }

}
