/* tslint:disable:whitespace */
export class CarModel{
  id: number;
  isRemoved: boolean;
  name: string;

  constructor(id: number, isRemoved: boolean, name: string){
    this.id =id;
    this.isRemoved=isRemoved;
    this.name=name;
  }
}
