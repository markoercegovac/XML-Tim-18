export interface AdvertDetailViewModel {
    
    advertId: number;
    profilePicture: string;
    gallery: string[];
    description: string;
    pricePerDay: number;
    insurancePrice: number;
    distanceOverflowPrice: number;
    discount: number;
    carBrand: string;
    carClass: string;
    carFuelType: string;
    carModel: string;
    carTransmissionType: string;
    carChildSeats: number;
    carAvailableDistanceWithoutOverflowPrice: number; //broj km koje moze da predje dok se ne aktivira distanceOverflow
}