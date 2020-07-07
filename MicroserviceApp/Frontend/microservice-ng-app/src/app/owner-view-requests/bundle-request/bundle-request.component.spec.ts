import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BundleRequestComponent } from './bundle-request.component';

describe('BundleRequestComponent', () => {
  let component: BundleRequestComponent;
  let fixture: ComponentFixture<BundleRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BundleRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BundleRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
