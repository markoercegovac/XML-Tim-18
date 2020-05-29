import { Component, OnInit, Input } from '@angular/core';
import { BundleModel } from 'src/app/model/bundle.model';

@Component({
  selector: 'app-bundle-item',
  templateUrl: './bundle-item.component.html',
  styleUrls: ['./bundle-item.component.css']
})
export class BundleItemComponent implements OnInit {

  @Input('bundle') bundle: BundleModel;
  
  constructor() { }

  ngOnInit(): void {
  }

}
