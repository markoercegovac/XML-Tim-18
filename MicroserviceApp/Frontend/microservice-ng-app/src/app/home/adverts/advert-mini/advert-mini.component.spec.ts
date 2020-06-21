import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdvertMiniComponent } from './advert-mini.component';

describe('AdvertMiniComponent', () => {
  let component: AdvertMiniComponent;
  let fixture: ComponentFixture<AdvertMiniComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdvertMiniComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdvertMiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
