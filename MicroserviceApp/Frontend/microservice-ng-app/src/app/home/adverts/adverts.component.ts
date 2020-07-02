import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {AdvertMiniModel} from '../../model/advert-mini.model';
import {AdvertService} from "../../services/advertService";

@Component({
  selector: 'app-adverts',
  templateUrl: './adverts.component.html',
  styleUrls: ['./adverts.component.css']
})
export class AdvertsComponent implements OnInit {

  adverts: AdvertMiniModel[] = [];

  constructor(private router: Router,private advertService:AdvertService) { }

  ngOnInit(): void {
    this.advertService.homeAllAdvert().subscribe(data=>{
      this.adverts=data;
      console.log(this.adverts);
    }
   )

  }



}


