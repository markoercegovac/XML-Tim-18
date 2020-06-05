import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCarTransmissionComponent } from './update-car-transmission.component';

describe('UpdateCarTransmissionComponent', () => {
  let component: UpdateCarTransmissionComponent;
  let fixture: ComponentFixture<UpdateCarTransmissionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateCarTransmissionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCarTransmissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
