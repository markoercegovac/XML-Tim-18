import { Component, OnInit } from '@angular/core';

import { AdvertMiniModel } from '../../model/advert-mini.model';
import { Router } from '@angular/router';
import {AdvertService} from '../../service/advert-service';

@Component({
  selector: 'app-adverts',
  templateUrl: './adverts.component.html',
  styles: [
  ]
})
export class AdvertsComponent implements OnInit {

  adverts: AdvertMiniModel[] = [];
  public profileImage:any;
  constructor(private router: Router , public advertService: AdvertService) { }

  ngOnInit(): void {

  }

  onAddAdvert() {
    this.router.navigate(['/home/ad/add']);
  }


}
