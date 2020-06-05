import { Component, OnInit } from '@angular/core';
import {Capture} from "../../../model/capture";
import {ActivatedRoute} from "@angular/router";
import {AdvertService} from "../../../services/advertService";

@Component({
  selector: 'app-capture',
  templateUrl: './capture.component.html',
  styleUrls: ['./capture.component.css']
})
export class CaptureComponent implements OnInit {
  adId: number = 0;
  allCaptures: Capture[];
  constructor(private activeUrl: ActivatedRoute,private advertService: AdvertService) { }

  ngOnInit(): void {
    this.adId=+this.activeUrl.snapshot.params['id'];

    this.advertService.getAllCaptureForAdvert(this.adId).subscribe(
      data=>{
        this.allCaptures=data;
      },
      error => {
        console.log('Error occurred',error);
      }
    );
  }

}
