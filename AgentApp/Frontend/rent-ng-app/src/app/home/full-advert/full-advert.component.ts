import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { DomSanitizer } from '@angular/platform-browser';
import { AdvertFullModel } from '../../model/advert-full.model';
import { AdvertService } from 'src/app/service/advert.service';

@Component({
  selector: 'app-full-advert',
  templateUrl: './full-advert.component.html',
  styles: [
  ]
})
export class FullAdvertComponent implements OnInit {

  adId: number;
  advert: AdvertFullModel;
  public profileImg;

  constructor(private currentUrl: ActivatedRoute,
      private adService: AdvertService, private _sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    //uzmi selektovani oglas
    this.adId = +this.currentUrl.snapshot.params['id'];

    this.adService.getAdvert(this.adId).subscribe(
      (data: any) => {
        this.profileImg = 'data:image/jpg;base64,' 
        + data.profileImage
      }
    );
  }

  public sanitize(url: string) {
    return this._sanitizer.bypassSecurityTrustUrl(url);
  }

}
