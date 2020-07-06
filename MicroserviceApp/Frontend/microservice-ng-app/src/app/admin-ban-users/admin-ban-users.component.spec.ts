import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBanUsersComponent } from './admin-ban-users.component';

describe('AdminBanUsersComponent', () => {
  let component: AdminBanUsersComponent;
  let fixture: ComponentFixture<AdminBanUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminBanUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBanUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
