import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ImageModel } from 'src/app/model/image.model';
import {PriceService} from '../../../service/price-service';
import {AdvertService} from '../../../service/advert-service';
import {Price} from '../../../model/price';
import {Car} from '../../../model/car';
import {PicModel} from '../../../model/picModel';
import {AdvertCreateModel} from '../../../model/advert-create.model';

@Component({
  selector: 'app-add-advert',
  templateUrl: './add-advert.component.html',
  styles: [
  ]
})
export class AddAdvertComponent implements OnInit {

  allPrices: Price[];
  allCars: Car[];
  profileImage: ImageModel;
  imageGalery: ImageModel[] = [];


  constructor(private advertService: AdvertService) { }

  ngOnInit(): void {
    this.advertService.getAllPrices().subscribe(

      data => {
        this.allPrices = data;
      },
      error => {
        console.log('Error occurred', error);
      }
    );
  }

  public onInputProfileImage(profileImageInput: any) {
    this.onLoadImage(profileImageInput, true);
  }

  public onInputGaleryImage(galeryImageInput: any) {
    this.onLoadImage(galeryImageInput, false);
  }

  private onLoadImage(img: any, isProfile: boolean) {
    const file: File = img.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', (event: any) => {

      if (isProfile === true) {
        this.profileImage = new ImageModel(0, event.target.result, file);
      } else {
        let id = this.imageGalery.length;
        this.imageGalery.push(new ImageModel(id, event.target.result, file));
      }
    }
    );

    reader.readAsDataURL(file);
  }

  public onClearImage(i: number) {
    this.imageGalery.splice(i, 1);
  }

  public onRemoveAll() {
    this.imageGalery = [];
  }

  public onRemoveProfileImage() {
    this.profileImage = null;
  }

  public onAddAd(form: NgForm) {
    let gallery: PicModel[]=[];

    for(let img of this.imageGalery){
      gallery.push(new PicModel(null,img.src,null,false,img.file.name));
    }
    let picModel: PicModel;
    picModel=new PicModel(null,this.profileImage.src,null,false,this.profileImage.file.name);


    let advert: AdvertCreateModel;
    advert=new AdvertCreateModel(null,picModel,gallery,new Date(),form.value.inputDate,form.value.inputDescription,
      true,null,form.value.inptuPrice);

    this.advertService.createAdvert(advert).subscribe();

  }

}
