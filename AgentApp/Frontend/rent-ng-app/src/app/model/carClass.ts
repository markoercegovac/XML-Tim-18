/* tslint:disable:whitespace */
export class CarClass{
  id: number;
  isRemoved: boolean;
  className: string;

  constructor(id: number, isRemoved: boolean, name: string){
    this.id=id;
    this.isRemoved=isRemoved;
    this.className=name;
  }
}
