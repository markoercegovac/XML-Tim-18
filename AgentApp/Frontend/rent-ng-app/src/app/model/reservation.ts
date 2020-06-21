export class Reservation {
  id: number;
  takeDate: Date;
  leaveDate: Date;
  advertId: number;

  constructor(id:number,take:Date,leave:Date,advert:number) {
    this.advertId=advert;
    this.id=id;
    this.leaveDate=leave;
    this.takeDate=take;
  }
}
