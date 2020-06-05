import {Picture} from "./picture";

export class Advert {
  profilePicture: string;
  pictureSet: Picture[];
  startOfAdvert: Date;
  endOfAdvert: Date;
  description: string;
  isActive: boolean;
  carId: number;
  priceId: number;

  constructor(pictureProf: string, pictureSet: Picture[], start: Date, end: Date,
               des: string, isActive: boolean, carId: number, pric: number) {
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
