import { Component, OnInit, Input } from '@angular/core';
import { RequestBundleModel } from 'src/app/model/request-bundle.model';
import { RequestService } from 'src/app/services/request.service';

@Component({
  selector: 'app-bundle-request',
  templateUrl: './bundle-request.component.html',
  styleUrls: ['./bundle-request.component.css']
})
export class BundleRequestComponent implements OnInit {

  @Input('bundle') bundle: RequestBundleModel;
  constructor(
    private bundleService: RequestService
  ) { }

  ngOnInit(): void {
  }

  onApprove() {
    this.bundleService.approveBundle(this.bundle.requestBundleId);
  }

  onCancel() {
    this.bundleService.cancelBundle(this.bundle.requestBundleId);
  }

  onDetailView() {
    alert("DETAIL VIEW IN IMPLEMENTATION")
  }

}
