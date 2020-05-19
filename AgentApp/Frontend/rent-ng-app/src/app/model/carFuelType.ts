export class CarFuelType{
  id: number;
  isRemoved: boolean;
  fuelType: string;

  constructor(id: number, isRemoved: boolean, name: string){
    this.id = id;
    this.isRemoved = isRemoved;
    this.fuelType = name;
  }
}
