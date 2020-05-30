import { Component, OnInit, Input } from '@angular/core';
import { AdvertInCartModel } from 'src/app/model/advert-in-cart.model';
import { BundleSerivce } from 'src/app/services/bundle.service';

@Component({
  selector: 'app-ad-item',
  templateUrl: './ad-item.component.html',
  styleUrls: ['./ad-item.component.css']
})
export class AdItemComponent implements OnInit {

  @Input('ad') ad: AdvertInCartModel;
  @Input('bundle-index') bundleIndex: number;
  validBundleNumbers: number[];

  constructor(private bundles: BundleSerivce) { }

  ngOnInit(): void {
  }

  onAddInBundle() {
    if(this.validBundleNumbers == null) {
      this.validBundleNumbers = this.bundles.ValidBundleNumbers(this.bundleIndex);
    } else {
      this.validBundleNumbers = null;
    }
  }

  onChangeBundle(toBundle: number) {
    this.bundles.addToBundle(this.bundleIndex, toBundle, this.ad.advertId);
  }

  onRemoveFromBundle() {
    this.bundles.removeFromBundle(this.bundleIndex, this.ad.advertId);
  }

  onDelete() {
    this.bundles.deleteAdFromBundle(this.bundleIndex, this.ad.advertId);
  }

  onClick() {
    this.bundles.setLastTuchedAd(this.ad.advertId);
  }
}
