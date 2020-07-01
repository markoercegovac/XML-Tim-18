import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllRegistrationRequestComponent } from './all-registration-request.component';

describe('AllRegistrationRequestComponent', () => {
  let component: AllRegistrationRequestComponent;
  let fixture: ComponentFixture<AllRegistrationRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllRegistrationRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllRegistrationRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
