import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ImageModel } from 'src/app/model/image.model';
import { AdvertService } from 'src/app/service/advert.service';
import { AdvertCreateModel } from 'src/app/model/advert-create.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-add-advert',
  templateUrl: './add-advert.component.html',
  styles: [
  ]
})
export class AddAdvertComponent implements OnInit {

  imageFile: File;
  profileImage: ImageModel;
  imageGalery: ImageModel[] = [];

  constructor(private adSerivce: AdvertService) { }

  ngOnInit(): void {
  }

  public getImageFile(event) {
    this.imageFile = event.target.files[0];
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
        this.profileImage = new ImageModel(0, event.target.result, this.imageFile);
      } else {
        let id = this.imageGalery.length;
        this.imageGalery.push(new ImageModel(id, event.target.result, this.imageFile));
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

    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.profileImage.file, this.profileImage.file.name);

    console.log(uploadImageData);
    let ad: AdvertCreateModel;
    ad = {
      carId: null,
      description: form.value.inputDescription,
      endOfAdvert: form.value.inputStartDate,
      startOfAdvert: form.value.inputEndDate,
      profileImage: this.profileImage.src
    };
    console.log(this.profileImage);
    uploadImageData.append('data', JSON.stringify(ad));

    this.adSerivce.createAd(ad).subscribe();
  }

}
