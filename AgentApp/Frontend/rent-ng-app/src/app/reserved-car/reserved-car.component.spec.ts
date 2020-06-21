import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservedCarComponent } from './reserved-car.component';

describe('ReservedCarComponent', () => {
  let component: ReservedCarComponent;
  let fixture: ComponentFixture<ReservedCarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservedCarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservedCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
