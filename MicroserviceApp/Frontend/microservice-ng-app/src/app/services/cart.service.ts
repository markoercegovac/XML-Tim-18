import { Injectable } from '@angular/core';
import { AdvertInCartModel } from '../model/advert-in-cart.model';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { MatDialog } from '@angular/material/dialog';
import { AddingToCartComponent } from '../adding-to-cart/adding-to-cart.component';

// const BASE_URl = environment.advertManagerUrl+ '/advert/';
const BASE_URl = environment.zuul+ '/advert-manager/advert/';

@Injectable({providedIn: 'root'})
export class CartService {

    private advertsInCart: AdvertInCartModel[] = [];

    constructor(
        private http: HttpClient,
        public dialog: MatDialog
    ) {}

    public addAdvertIdInCart(id: number) {
        this.http.get<AdvertInCartModel>(BASE_URl+id+"?details=cart").subscribe(
            data => {
                let advert = data;
                
                const dialogRef = this.dialog.open(AddingToCartComponent, {width: '60%'});
                
                dialogRef.afterClosed().subscribe(
                    data => {
                        console.log(data);
                        if(data.start != null) {
                            advert.endDate = data.end;
                            advert.startDate = data.start;
                            this.addAdvertInCart(advert);
                        }
                    }
                );
            }, error => {
                alert('SERVER ERROR');
            }
        );
    }

    public addAdvertInCart(advert: AdvertInCartModel) {
        this.advertsInCart.push(advert);
        console.log('added advert to cart', advert);
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

<<<<<<< HEAD
    public emptyCart() {
        this.advertsInCart = [];
    }

    public onLoad(cartItems: string) {
        this.advertsInCart = JSON.parse(cartItems);
    }

}
=======
}
>>>>>>> origin/master
