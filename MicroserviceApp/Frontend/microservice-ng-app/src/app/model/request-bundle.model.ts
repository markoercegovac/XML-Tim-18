import { AdvertRequestModel } from '../model/advert-request.model';

export interface RequestBundleModel {
	requestBundleId: number;
    requests: AdvertRequestModel[];
    requestingUserEmail: string;
    status: string;
    priceWithDiscount: number;
}