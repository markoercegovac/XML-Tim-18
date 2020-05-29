import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPriceListComponent } from './my-price-list.component';

describe('MyPriceListComponent', () => {
  let component: MyPriceListComponent;
  let fixture: ComponentFixture<MyPriceListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyPriceListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyPriceListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
