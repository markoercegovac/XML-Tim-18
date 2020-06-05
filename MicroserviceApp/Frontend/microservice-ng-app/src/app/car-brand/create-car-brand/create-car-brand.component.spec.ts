import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCarBrandComponent } from './create-car-brand.component';

describe('CreateCarBrandComponent', () => {
  let component: CreateCarBrandComponent;
  let fixture: ComponentFixture<CreateCarBrandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCarBrandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCarBrandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
