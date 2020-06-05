import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvertDetailViewComponent } from './advert-detail-view.component';

describe('AdvertDetailViewComponent', () => {
  let component: AdvertDetailViewComponent;
  let fixture: ComponentFixture<AdvertDetailViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvertDetailViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvertDetailViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
