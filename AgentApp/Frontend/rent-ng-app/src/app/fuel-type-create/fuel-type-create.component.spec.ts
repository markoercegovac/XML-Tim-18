import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelTypeCreateComponent } from './fuel-type-create.component';

describe('FuelTypeCreateComponent', () => {
  let component: FuelTypeCreateComponent;
  let fixture: ComponentFixture<FuelTypeCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FuelTypeCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FuelTypeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
