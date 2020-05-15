export class Car {

  id: number;
  childrenSitNumber: number;
  isInsurance: boolean;
  travelDistance: number;
  carBrand: number;
  carClass: number;
  carFuelType: number;
  carModel: number;
  carTransmissionType: number;


  constructor(id: number, children: number, isInsurance: boolean, travelDistance: number, carBrand: number, carClass: number, carModel: number, carTransmission: number) {
    this.id = id;
    this.childrenSitNumber = children;
    this.carBrand = carBrand;
    this.carFuelType = this.carFuelType;
    this.isInsurance = isInsurance;
    this.travelDistance = travelDistance;
    this.carTransmissionType = carTransmission;
    this.carClass=carClass;
  }

}
