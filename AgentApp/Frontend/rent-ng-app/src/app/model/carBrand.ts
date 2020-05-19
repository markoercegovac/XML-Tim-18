/* tslint:disable:no-trailing-whitespace whitespace */
export class CarBrand{
  id: number;
  isRemoved: boolean;
  name: string;

  constructor(id: number, isRemoved: boolean, name: string){
    this.id=id;
    this.isRemoved=isRemoved;
    this.name=name;
  }

}
