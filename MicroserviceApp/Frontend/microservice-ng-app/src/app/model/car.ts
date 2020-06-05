export class Car {

  id: number;
  childrenSitNumber: number;
  isInsurance: boolean;
  travelDistance: number;
  carBrandId: number;
  carClassId: number;
  carFuelTypeId: number;
  carModelId: number;
  carTransmissionTypeId: number;
  year: string;
  nameOfCar: string;


  constructor(id: number, children: number, isInsurance: boolean, travelDistance: number, carBrand: number, carClass: number, carModel: number, carTransmission: number, year: string, fuel: number, name: string) {
    this.id = id;
    this.nameOfCar=name;
    this.childrenSitNumber = children;
    this.carBrandId = carBrand;
    this.carFuelTypeId = fuel;
    this.isInsurance = isInsurance;
    this.travelDistance = travelDistance;
    this.carTransmissionTypeId = carTransmission;
    this.carClassId=carClass;
    this.carModelId=carModel;
    this.year=year;
  }

}
