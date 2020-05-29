import { Injectable } from '@angular/core';
import { BundleModel } from '../model/bundle.model';
import { CartService } from './cart.service';
import { AdvertInCartModel } from '../model/advert-in-cart.model';

@Injectable({providedIn: 'root'})
export class BundleSerivce {

    private bundles: BundleModel[] = [];

    constructor(private cart: CartService) {}

    public bundleInit() {
        this.bundles = [];

        for(let ad of this.cart.getAllAdverts()) {
            let foundIndex = this.bundles.findIndex((b: BundleModel) => {
                return (b.ownerEmail == ad.ownerEmail);
            });

            if(foundIndex != -1) {
                this.bundles[foundIndex].adverts.push(ad);
            } else {
                let lastIndex = this.bundles.length;
                this.bundles.push({index: lastIndex, ownerEmail: ad.ownerEmail, adverts: [ad]});
            }
        }
    }

    public getBundles(): BundleModel[] {
        return this.bundles;
    }

    public addToBundle() {

    }

    public removeFromBundle(bundleIndex: number, adId: number) {
        let i = this.checkIfAdvertIsInValidBundle(bundleIndex, adId);
        if(i != -1) {
            //last ad in bundle cannot be removed
            if(this.bundles[bundleIndex].adverts.length == 1) {
                return;
            }

            //removes ad from bundle
            let ad: AdvertInCartModel = this.bundles[bundleIndex].adverts[i];
            this.bundles[bundleIndex].adverts.splice(i, 1);
    
            //creates a new bundle with the removed ad
            let lastIndex = this.bundles.length;
            this.bundles.push({index: lastIndex, ownerEmail: ad.ownerEmail, adverts: [ad]});
        }
    }

    public deleteAdFromBundle(bundleIndex: number, adId: number) {
        let i = this.checkIfAdvertIsInValidBundle(bundleIndex, adId);
        if(i != -1) {
            //removes ad from bundle
            let ad: AdvertInCartModel = this.bundles[bundleIndex].adverts[i];
            this.bundles[bundleIndex].adverts.splice(i, 1);
    
            //remove ad from cart
            this.cart.removeAdvertFromCart(ad.advertId);

            //if the bundle is empty remove it and calculate bundle indexes
            if(this.bundles[bundleIndex].adverts.length <= 0) {
                this.bundles.splice(bundleIndex, 1);

                let i = 0;
                for(let b of this.bundles) {
                    b.index = i++;
                }
            }

        }
    }

    private checkIfAdvertIsInValidBundle(bundleIndex: number, adId: number): number {
        //returns the index of advert in bundle; if something is not ok return -1
        
        if(this.bundles[bundleIndex] != null && this.bundles[bundleIndex] != undefined) {
            let i = this.bundles[bundleIndex].adverts.findIndex((ad: AdvertInCartModel) => {
                return (ad.advertId == adId);
            });
            if(i != -1) {
                return i;
            }
        }
        return -1;
    }

}