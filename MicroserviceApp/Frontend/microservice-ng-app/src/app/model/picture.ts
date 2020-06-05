export class Picture {
  id: number;
  picture: string;
  advertId: number;
  isDeleted: boolean;

  constructor(id: number, pic: string, adv: number, deleted: boolean) {
    this.id=id;
    this.advertId=adv;
    this.isDeleted=deleted;
    this.picture=pic;
  }



}
