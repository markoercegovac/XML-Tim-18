import { Component, OnInit, Input } from '@angular/core';
import { RequestBundleModel } from 'src/app/model/request-bundle.model';
import { RequestService } from 'src/app/services/request.service';
import { AdvertRequestModel } from 'src/app/model/advert-request.model';
import { AdvertService } from 'src/app/services/advert.service';

@Component({
  selector: 'app-ad-request-item',
  templateUrl: './ad-request-item.component.html',
  styleUrls: ['./ad-request-item.component.css']
})
export class AdRequestItemComponent implements OnInit {

  @Input('ad') ad: AdvertRequestModel;
  profileImg: string;
  
  constructor(
    private adService: AdvertService
  ) { }

  ngOnInit(): void {
    this.adService.getProfileImg(this.ad.advertId).subscribe(
      data => {
        this.profileImg = data;
      }
    );
  }

}
