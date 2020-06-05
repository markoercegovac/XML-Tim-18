import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFuelTypeComponent } from './create-fuel-type.component';

describe('CreateFuelTypeComponent', () => {
  let component: CreateFuelTypeComponent;
  let fixture: ComponentFixture<CreateFuelTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateFuelTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateFuelTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
