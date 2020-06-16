import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {ImageModel} from '../../model/image';
import {Price} from "../../model/price";
import {PriceService} from "../../services/price.service";
import {Advert} from "../../model/advert";
import {Picture} from "../../model/picture";
import {AdvertService} from "../../services/advertService";
import {Car} from "../../model/car";
import {CarService} from "../../services/car.service";

@Component({
  selector: 'app-create-advert',
  templateUrl: './create-advert.component.html',
  styleUrls: ['./create-advert.component.css']
})
export class CreateAdvertComponent implements OnInit {

  profileImage: ImageModel;
  imageGallery: ImageModel[] = [];
  allPrices: Price [];
  allCars: Car [];
  startDate: Date;
  endDate: Date;
  desc: string;
  carId: number;
  priceId: number;

  constructor(private priceService: PriceService, private advertService: AdvertService, private carService: CarService) { }

  ngOnInit(): void {
    this.priceService.getUserPriceList().subscribe(
      data=>{
        this.allPrices=data;
      })
    this.carService.getUserCarList().subscribe(
      data=>{
        this.allCars=data;
      }
    )

  }

  public onInputProfileImage(profileImageInput: any) {
    this.onLoadImage(profileImageInput, true);
  }
  public onInputGalleryImage(galleryImageInput: any){
    this.onLoadImage(galleryImageInput, false);
  }

  public onRemoveProfileImage() {
    this.profileImage = null;
  }
  private onLoadImage(img: any, isProfile: boolean){
    const file: File = img.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', (event: any) => {
      if (isProfile === true){
        this.profileImage = new ImageModel(0, event.target.result, file);

      }
      else{
        const id = this.imageGallery.length;
        this.imageGallery.push(new ImageModel(id, event.target.result, file));
      }
    });
    reader.readAsDataURL(file);
  }

  public createAdvert() {
    let gallery:Picture[]=[];

    for(let img of this.imageGallery){
      gallery.push(new Picture(null,img.src,null,false));
    }
    // if(!(this.startDate<this.endDate)){
    //   return;
    // }if(!(this.startDate>=new Date())){
    //   return;
    // }
    let advert:Advert;
    advert=new Advert(null,this.profileImage.src,gallery,this.startDate,this.endDate,this.desc,true,this.carId,this.priceId);
    this.advertService.createAdvert(advert).subscribe();

  }

  public onClearImage(i: number) {
    this.imageGallery.splice(i, 1);
  }
}
