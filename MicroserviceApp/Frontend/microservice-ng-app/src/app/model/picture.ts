export class Picture {
  id: number;
  picture: string;
  advertId: number;
  isDeleted: boolean;
  path: string;

  constructor(id: number, pic: string, adv: number, deleted: boolean,path: string) {
    this.id=id;
    this.advertId=adv;
    this.isDeleted=deleted;
    this.picture=pic;
    this.path=path;
  }



}
