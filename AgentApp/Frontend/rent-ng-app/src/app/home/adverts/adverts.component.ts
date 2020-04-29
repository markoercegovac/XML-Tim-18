import { Component, OnInit } from '@angular/core';

import { AdvertMiniModel } from '../../model/advert-mini.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adverts',
  templateUrl: './adverts.component.html',
  styles: [
  ]
})
export class AdvertsComponent implements OnInit {

  adverts: AdvertMiniModel[] = [];

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.mock();
  }

  onAddAdvert() {
    this.router.navigate(['/home/ad/add']);
  }

  mock() {
    this.adverts.push({ advertId: 1, profileImage: 'image1', traveledDistance: 250, distanceUnit: 'km', carBrand: 'toyota', carModel: 'yaris', grade: 4, price: 500 });
    this.adverts.push({ advertId: 2, profileImage: 'image2', traveledDistance: 300, distanceUnit: 'km', carBrand: 'toyota', carModel: 'yaris', grade: 4, price: 600 });
    this.adverts.push({ advertId: 3, profileImage: 'image3', traveledDistance: 500, distanceUnit: 'km', carBrand: 'yugo', carModel: 'koral', grade: 2, price: 500 });
    this.adverts.push({ advertId: 4, profileImage: 'image4', traveledDistance: 250, distanceUnit: 'km', carBrand: 'fiat', carModel: 'prglica', grade: 5, price: 500 });
  }
}
