export class CarTransmission{
  id: number;
  isRemoved: boolean;
  transmissionType: string;

  constructor(id: number, isRemoved: boolean, name: string){
    this.id = id;
    this.isRemoved = isRemoved;
    this.transmissionType = name;
  }
}
