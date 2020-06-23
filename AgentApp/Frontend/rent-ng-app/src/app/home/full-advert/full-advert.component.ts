import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { AdvertFullModel } from '../../model/advert-full.model';
import {AdvertService} from '../../service/advert-service';

@Component({
  selector: 'app-full-advert',
  templateUrl: './full-advert.component.html',
  styles: [
  ]
})
export class FullAdvertComponent implements OnInit {

  adId: number;
  advert: AdvertFullModel;
  grade: number;

  constructor(private currentUrl: ActivatedRoute,private advertService: AdvertService) { }

  ngOnInit(): void {
    //uzmi selektovani oglas
    this.adId = +this.currentUrl.snapshot.params['id'];
    this.advertService.getGradeForAdvert(this.adId).subscribe(
      data=>{
        this.grade=data;
      }
    );

    this.advertService.getAdvert(this.adId).subscribe(
      data=>{
        this.advert=data;
        console.log(this.advert);
      }
    );
  }

  createGrade() {

  }
}
