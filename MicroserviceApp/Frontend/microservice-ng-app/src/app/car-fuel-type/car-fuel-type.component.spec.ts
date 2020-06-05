import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarFuelTypeComponent } from './car-fuel-type.component';

describe('CarFuelTypeComponent', () => {
  let component: CarFuelTypeComponent;
  let fixture: ComponentFixture<CarFuelTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarFuelTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarFuelTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
