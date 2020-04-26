import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-full-advert',
  templateUrl: './full-advert.component.html',
  styles: [
  ]
})
export class FullAdvertComponent implements OnInit {

  adId: number;

  constructor(private currentUrl: ActivatedRoute) { }

  ngOnInit(): void {
    //uzmi selektovani oglas
    this.adId = +this.currentUrl.snapshot.params['id'];
  }

}
