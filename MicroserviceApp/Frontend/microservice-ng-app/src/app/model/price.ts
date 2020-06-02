export class Price {
  id: number;
  priceName: string;
  pricePerDay: number;
  insurancePrice: number;
  distanceOverflowPrice: number;


  constructor(id: number, name: string, pricePerDay: number, insurance: number, distanceOver: number){
    this.id = id;
    this.priceName = name;
    this.pricePerDay = pricePerDay;
    this.insurancePrice = insurance;
    this.distanceOverflowPrice = distanceOver;

  }
}
