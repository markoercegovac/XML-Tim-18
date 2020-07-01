import {Picture} from "./picture";

export class Advert {
  id: number;
  profilePicture: Picture;
  pictureSet: Picture[];
  startOfAdvert: Date;
  endOfAdvert: Date;
  description: string;
  isActive: boolean;
  carId: number;
  priceId: number;

  constructor(id: number, pictureProf: Picture, pictureSet: Picture[], start: Date, end: Date,
               des: string, isActive: boolean, carId: number, pric: number) {
    this.id=id;
    this.profilePicture=pictureProf;
    this.pictureSet=pictureSet;
    this.startOfAdvert=start;
    this.endOfAdvert=end;
    this.description=des;
    this.isActive=isActive;
    this.carId=carId;
    this.priceId=pric;


  }
}
