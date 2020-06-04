import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {ImageModel} from '../../model/image';

@Component({
  selector: 'app-create-advert',
  templateUrl: './create-advert.component.html',
  styleUrls: ['./create-advert.component.css']
})
export class CreateAdvertComponent implements OnInit {

  profileImage: ImageModel;
  imageGallery: ImageModel[] = [];

  constructor() { }

  ngOnInit(): void {
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

  public createAdvert(f: NgForm) {
    alert('Advert Created');
  }

  public onClearImage(i: number) {
    this.imageGallery.splice(i, 1);
  }
}
