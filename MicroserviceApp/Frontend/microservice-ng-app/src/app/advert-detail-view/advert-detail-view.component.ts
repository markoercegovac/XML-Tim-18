import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdvertDetailViewModel } from '../model/advert-detail-view.model';

@Component({
  selector: 'app-advert-detail-view',
  templateUrl: './advert-detail-view.component.html',
  styleUrls: ['./advert-detail-view.component.css']
})
export class AdvertDetailViewComponent implements OnInit {

  adId: number = 0;
  ad: AdvertDetailViewModel;

  constructor(private activeUrl: ActivatedRoute) { }

  ngOnInit(): void {
    this.adId = +this.activeUrl.snapshot.params['id'];
    //poziv servera za ad
  }

}
