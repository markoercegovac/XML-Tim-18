export interface AdvertDetailViewModel {
    
    advertId: number;
    profilePicture: string;
    gallery: string[];
    description: string;
    pricePerDay: number;
    insurancePrice: number;
    distanceOverflowPrice: number;
    discount: number;
    mileage: number;
    mileageUnit: string;
    carBrand: string;
    carClass: string;
    carFuelType: string;
    carModel: string;
    carTransmissionType: string;
    carChildSeatNumber: number;
    carAvailableDistanceWithoutOverflowPrice: number; //broj km koje moze da predje dok se ne aktivira distanceOverflow
}