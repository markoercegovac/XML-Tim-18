export class Price  {
  id: number;
  name: string;
  pricePerDay: number;
  insurancePrice: number;
  distanceOverflowPrice: number;
  discount: number;
  isRemoved: boolean;

  constructor(id: number, name: string, price: number, insurance: number, distance: number, discount: number, rem: boolean) {
    this.discount = discount;
    this.id = id;
    this.distanceOverflowPrice = distance;
    this.pricePerDay = price;
    this.insurancePrice = insurance;
    this.name = name;
    this.isRemoved = rem;
  }
}
