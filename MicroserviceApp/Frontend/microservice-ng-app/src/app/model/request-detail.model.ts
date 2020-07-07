import { AdvertRequestModel } from './advert-request.model';

export interface RequestDetailModel {

	requestBundleId: number;
    advertOwnerEmail: string;
    status: string;
	priceWithDiscount: number;
    advertRequests: AdvertRequestModel[];
}