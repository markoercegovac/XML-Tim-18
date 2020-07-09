import { Component, OnInit } from '@angular/core';
import {AdvertMiniModel} from '../model/advert-mini.model';
import {AdvertService} from '../service/advert-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-my-advert',
  templateUrl: './my-advert.component.html',
  styleUrls: ['./my-advert.component.css']
})
export class MyAdvertComponent implements OnInit {

  allAdverts: AdvertMiniModel[];

  constructor(private advertService: AdvertService, private router: Router) { }

  ngOnInit(): void {
    this.advertService.getMyAdverts().subscribe(
      data => {
        this.allAdverts = data;
        console.log(this.allAdverts)
      }
    );
  }

  reserved(advert: AdvertMiniModel) {
    this.router.navigate(['/car/reserved/' + advert.advertId]);
  }
}
