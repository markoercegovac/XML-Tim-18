import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarTranssmisionTypeComponent } from './car-transsmision-type.component';

describe('CarTranssmisionTypeComponent', () => {
  let component: CarTranssmisionTypeComponent;
  let fixture: ComponentFixture<CarTranssmisionTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarTranssmisionTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarTranssmisionTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
