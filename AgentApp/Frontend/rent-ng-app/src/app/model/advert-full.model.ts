export interface AdvertFullModel {
    
    id: number;
    profileImage: string;
    galeryImages: string[];
    price: number;
    grade: number;
    ownerEmail: string;
    firmName: string;
    description: string;

    //car specifik
    traveledDistance: number;
    distanceUnit: string;
    carBrand: string;
    carModel: string;
    carClass: string;
    CarFuelType: string;
    CarTransmissionType: string;
    isInsurance: boolean;

}