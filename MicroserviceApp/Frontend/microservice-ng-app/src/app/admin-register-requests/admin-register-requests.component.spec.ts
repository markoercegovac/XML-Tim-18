import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminRegisterRequestsComponent } from './admin-register-requests.component';

describe('AdminRegisterRequestsComponent', () => {
  let component: AdminRegisterRequestsComponent;
  let fixture: ComponentFixture<AdminRegisterRequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminRegisterRequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminRegisterRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
