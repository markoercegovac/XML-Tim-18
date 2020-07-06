import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterApprovedComponent } from './register-approved.component';

describe('RegisterApprovedComponent', () => {
  let component: RegisterApprovedComponent;
  let fixture: ComponentFixture<RegisterApprovedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterApprovedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterApprovedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
