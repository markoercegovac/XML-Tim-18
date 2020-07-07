import { Component, OnInit, Input } from '@angular/core';
import { AdvertRequestModel } from 'src/app/model/advert-request.model';
import { AdvertService } from 'src/app/services/advert.service';

@Component({
  selector: 'app-requesting-ad-item',
  templateUrl: './requesting-ad-item.component.html',
  styleUrls: ['./requesting-ad-item.component.css']
})
export class RequestingAdItemComponent implements OnInit {

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
