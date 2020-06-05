import { Component, OnInit } from '@angular/core';
import {AdvertService} from "../../services/advertService";
import {Advert} from "../../model/advert";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-my-adverts',
  templateUrl: './my-adverts.component.html',
  styleUrls: ['./my-adverts.component.css']
})
export class MyAdvertsComponent implements OnInit {

  adId: number = 0;
  allAdverts: Advert[];


  constructor(private advertService:AdvertService,private router: Router) { }

  ngOnInit(): void {

    this.advertService.getAllAdverts().subscribe(
      data=>{
        this.allAdverts=data;
      },
      error => {
        console.log('Error occurred', error);
      }
    );
  }

  captureDate(advert: Advert) {
      this.router.navigate(["my/advert/"+advert.id]);
  }
}
