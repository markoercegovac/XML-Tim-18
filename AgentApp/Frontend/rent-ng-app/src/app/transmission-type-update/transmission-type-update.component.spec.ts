import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransmissionTypeUpdateComponent } from './transmission-type-update.component';

describe('TransmissionTypeUpdateComponent', () => {
  let component: TransmissionTypeUpdateComponent;
  let fixture: ComponentFixture<TransmissionTypeUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransmissionTypeUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransmissionTypeUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
