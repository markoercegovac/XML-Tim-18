import { Component, OnInit, Input } from '@angular/core';
import { AdvertMiniModel } from 'src/app/model/advert-mini.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-advert-mini',
  templateUrl: './advert-mini.component.html',
  styles: [
  ]
})
export class AdvertMiniComponent implements OnInit {

  @Input("ad") advert:AdvertMiniModel;


  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  showFullAdvert() {
    this.router.navigate(['/home/ad', this.advert.id ]);
  }

}
