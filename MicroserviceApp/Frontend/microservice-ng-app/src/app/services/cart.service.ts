import { Injectable } from '@angular/core';
import { AdvertInCartModel } from '../model/advert-in-cart.model';
import { noUndefined } from '@angular/compiler/src/util';

@Injectable({providedIn: 'root'})
export class CartService {

    private advertsInCart: AdvertInCartModel[] = [];

    public addAdvertInCart(advert: AdvertInCartModel) {
        this.advertsInCart.push(advert);
    }

    public removeAdvertFromCart(advertId: number) {
        let ad = this.getAdvert(advertId);

        if(ad != null) {
            let index = this.advertsInCart.indexOf(ad);
            this.advertsInCart.splice(index, 1);
        }
    }

    public getAllAdverts(): AdvertInCartModel[] {
        return this.advertsInCart;
    }

    public getAdvert(advertId: number): AdvertInCartModel {
        for(let advert of this.advertsInCart) {
            if(advert.advertId === advertId) {
                return advert;
            }
        }

        return null;
    }

}