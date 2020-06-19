export class PicModel {
  id: number;
  picture: string;
  path: File;
  advertId: number;
  isDeleted: boolean;

  constructor(id: number, pic: string, adv: number, deleted: boolean, path: string) {
    this.id=id;
    this.advertId=adv;
    this.isDeleted=deleted;
    this.picture=pic;
    this.path=path;
  }
}
