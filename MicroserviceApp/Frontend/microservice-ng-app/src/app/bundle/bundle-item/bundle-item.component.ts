import { Component, OnInit, Input } from '@angular/core';
import { BundleModel } from 'src/app/model/bundle.model';
import { CdkDragDrop } from '@angular/cdk/drag-drop';
import { BundleSerivce } from 'src/app/services/bundle.service';

@Component({
  selector: 'app-bundle-item',
  templateUrl: './bundle-item.component.html',
  styleUrls: ['./bundle-item.component.css']
})
export class BundleItemComponent implements OnInit {

  @Input('bundle') bundle: BundleModel;
  bundleList: string[] = [];

  constructor(public bundleService: BundleSerivce) { }

  ngOnInit(): void {
    this.bundleService.getBundleList();
  }

  onDrop(event: CdkDragDrop<string[]>) { 
    let previousBundleIndex = Number.parseInt(event.previousContainer.id);
    let currentBundleIndex = Number.parseInt(event.container.id);

    if(previousBundleIndex != currentBundleIndex) {
      this.bundleService.dragAndDrop(previousBundleIndex, currentBundleIndex);
    }

  }

}
