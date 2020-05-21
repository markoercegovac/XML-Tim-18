import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ImageModel } from 'src/app/model/image.model';

@Component({
  selector: 'app-add-advert',
  templateUrl: './add-advert.component.html',
  styles: [
  ]
})
export class AddAdvertComponent implements OnInit {

  profileImage: ImageModel;
  imageGalery: ImageModel[] = [];

  constructor() { }

  ngOnInit(): void {
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
    console.log(form.value.inputDescription);
  }

}
