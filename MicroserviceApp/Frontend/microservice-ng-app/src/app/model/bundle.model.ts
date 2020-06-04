import { AdvertInCartModel } from './advert-in-cart.model';

export interface BundleModel {

    index: number;
    ownerEmail: string;
    adverts: AdvertInCartModel[];
}