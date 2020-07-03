import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdvertDetailViewModel } from '../model/advert-detail-view.model';
import { AdvertService } from '../services/advert.service';
import { DomSanitizer } from '@angular/platform-browser';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-advert-detail-view',
  templateUrl: './advert-detail-view.component.html',
  styleUrls: ['./advert-detail-view.component.css']
})
export class AdvertDetailViewComponent implements OnInit {

  adId: number = 0;
  ad: AdvertDetailViewModel;
  profileImg: any;

  constructor(
    private activeUrl: ActivatedRoute,
    private adService: AdvertService,
    private domSanitizer: DomSanitizer,
    private cart: CartService) { }

  ngOnInit(): void {
    this.adId = +this.activeUrl.snapshot.params['id'];

    this.adService.getAdvertDetail(this.adId).subscribe(
      (data: AdvertDetailViewModel) => {
        if(data != null) {
          this.ad = data;

          console.log(this.ad);
        } else {
          //this.router.navigate(['/not-found']);
        }
      }
    );
  }

  onCart() {
    this.cart.addAdvertIdInCart(this.adId);
  }

}
