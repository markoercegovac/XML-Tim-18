import { Component, OnInit, Input } from '@angular/core';
import { RequestDetailModel } from 'src/app/model/request-detail.model';

@Component({
  selector: 'app-requests-bundle',
  templateUrl: './requests-bundle.component.html',
  styleUrls: ['./requests-bundle.component.css']
})
export class RequestsBundleComponent implements OnInit {

  @Input('bundle') bundle: RequestDetailModel;

  constructor() { }

  ngOnInit(): void {
  }

}
