import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {AdvertFullModel} from '../../model/advert-full.model';

@Component({
  selector: 'app-full-advert',
  templateUrl: './full-advert.component.html',
  styleUrls: ['./full-advert.component.css']
})
export class FullAdvertComponent implements OnInit {

  adId: number;
  advert: AdvertFullModel;

  constructor(private currentUrl: ActivatedRoute) { }

  ngOnInit(): void {
    // uzmi selektovani oglas
    this.adId = +this.currentUrl.snapshot.params.id;
    console.log('id koji preuzima comments je : ',this.adId);
  }

}
