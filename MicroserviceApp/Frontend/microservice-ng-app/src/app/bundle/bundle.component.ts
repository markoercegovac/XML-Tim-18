import { Component, OnInit } from '@angular/core';
import { BundleSerivce } from '../services/bundle.service';

@Component({
  selector: 'app-bundle',
  templateUrl: './bundle.component.html',
  styleUrls: ['./bundle.component.css']
})
export class BundleComponent implements OnInit {

  constructor(public bundles: BundleSerivce) { }

  ngOnInit(): void {
    this.bundles.bundleInit();
  }

  onConfirm() {
    this.bundles.createBundleRequest();
  }
}
