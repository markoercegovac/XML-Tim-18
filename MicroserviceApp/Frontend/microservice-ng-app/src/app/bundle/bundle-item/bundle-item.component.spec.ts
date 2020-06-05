import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BundleItemComponent } from './bundle-item.component';

describe('BundleItemComponent', () => {
  let component: BundleItemComponent;
  let fixture: ComponentFixture<BundleItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BundleItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BundleItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
