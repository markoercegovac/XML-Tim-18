export class Capture {
  id: number;
  takeDate: Date;
  leaveDate: Date;
  advertId: number;

  constructor(id: number, take: Date, leave: Date,adv:number) {
    this.id=id;
    this.takeDate=take;
    this.leaveDate=leave;
    this.advertId=adv
  }

}
