import { Injectable } from '@angular/core';
import { BundleModel } from '../model/bundle.model';
import { CartService } from './cart.service';
import { AdvertInCartModel } from '../model/advert-in-cart.model';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

// const BASE_URL = environment.requestManagerUrl;
const BASE_URl = environment.zuul+ '/advert-request';

@Injectable({providedIn: 'root'})
export class BundleSerivce {

    private bundles: BundleModel[] = [];
    private lastTouchedAdId: number = 0;

    constructor(
        private cart: CartService,
        private http: HttpClient,
        private auth: AuthService,
        private router: Router
    ) {}

    public createBundleRequest() {
        //sends http request and creates advert request on backend
        if(this.bundles.length <= 0) {
            return;
        }

        for(let b of this.bundles) {

            let dto = {
                advertOwnerEmail: b.ownerEmail,
                requestingUserEmail: this.auth.getCurrentUserEmail(),
                priceWithDiscount: 0,
                requestedAdverts: []
            };
            for(let ad of b.adverts)  {
                dto.priceWithDiscount += ad.price;
                dto.requestedAdverts.push({
                    advertId: ad.advertId,
                    startDate: ad.startDate,
                    endDate: ad.endDate
                });
            }
            
            this.http.post(BASE_URl+'/client', dto, { responseType: 'text' }).subscribe(
                data => {
                    alert('SECCESFULLY CREATED REQUEST');
                    this.bundles = [];
                    this.cart.emptyCart();
                    this.router.navigate(['/home/advert/all']);
                },
                error => {
                    alert('SOMETHING WENT WRONG\n' + error.error);
                }
            );
        }

    }

    public bundleInit() {
        //when user goes to bundle page use adverts from cart to create bundles
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
        //for displaying bundle
        return this.bundles;
    }

    public ValidBundleNumbers(bundleIndex: number): number[] {
        //returns array of bundle indexes that ad can be movet to
        let owner = this.bundles[bundleIndex].ownerEmail;

        if(owner != null) {
            let validBundles: number[] = [];

            for(let b of this.bundles) {
                if(b.index != bundleIndex && b.ownerEmail == owner) {
                    validBundles.push(b.index);
                }
            }

            if(validBundles.length > 0) {
                return validBundles;
            }
        }

        return null;
    }

    public addToBundle(fromBundleIndex: number, toBundleIndex: number, adId: number) {
        //move ad from one bundle to a nother(valid)
        let i = this.checkIfAdvertIsInValidBundle(fromBundleIndex, adId);
        if(i != -1) {
            let ad: AdvertInCartModel = this.RemoveAdFromBundle(fromBundleIndex, i);

            //moves ad to bundle
            this.bundles[toBundleIndex].adverts.push(ad);

            this.removeBundleIfEmpty(fromBundleIndex);
        }
    }

    public dragAndDrop(fromBundleIndex: number, toBundleIndex: number) {
        //alert('from '+fromBundleIndex+' to '+toBundleIndex+' ad '+this.lastTouchedAdId)
        
        if(this.bundles[fromBundleIndex].ownerEmail == this.bundles[toBundleIndex].ownerEmail) {
            //alert('in');
            this.addToBundle(fromBundleIndex, toBundleIndex, this.lastTouchedAdId);
        }
    }

    public setLastTuchedAd(adId: number) {
        this.lastTouchedAdId = adId;
    }

    public getBundleList(): string[] {
        let bundleList: string[] = []
        for(let b of this.bundles) {
            bundleList.push(b.index.toString());
        }
        return bundleList;
    }

    public removeFromBundle(bundleIndex: number, adId: number) {
        //removes ad from bundle;
        let i = this.checkIfAdvertIsInValidBundle(bundleIndex, adId);
        if(i != -1) {
            //last ad in bundle cannot be removed
            if(this.bundles[bundleIndex].adverts.length == 1) {
                return;
            }

            let ad: AdvertInCartModel = this.RemoveAdFromBundle(bundleIndex, i);
    
            //creates a new bundle with the removed ad
            let lastIndex = this.bundles.length;
            this.bundles.push({index: lastIndex, ownerEmail: ad.ownerEmail, adverts: [ad]});
        }
    }

    public deleteAdFromBundle(bundleIndex: number, adId: number) {
        let i = this.checkIfAdvertIsInValidBundle(bundleIndex, adId);
        if(i != -1) {
            let ad: AdvertInCartModel = this.RemoveAdFromBundle(bundleIndex, i);
    
            //remove ad from cart
            this.cart.removeAdvertFromCart(ad.advertId);

            this.removeBundleIfEmpty(bundleIndex);

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

    private removeBundleIfEmpty(bundleIndex: number) {
        //if the bundle is empty remove it and calculate bundle indexes
        if(this.bundles[bundleIndex].adverts.length <= 0) {
            this.bundles.splice(bundleIndex, 1);

            let i = 0;
            for(let b of this.bundles) {
                b.index = i++;
            }
        }
    }

    private RemoveAdFromBundle(bundleIndex: number, adIndex: number): AdvertInCartModel {
        //removes ad from bundle
        let ad: AdvertInCartModel = this.bundles[bundleIndex].adverts[adIndex];
        this.bundles[bundleIndex].adverts.splice(adIndex, 1);
        return ad;
    }

}