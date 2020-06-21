import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCommentsAllowComponent } from './admin-comments-allow.component';

describe('AdminCommentsAllowComponent', () => {
  let component: AdminCommentsAllowComponent;
  let fixture: ComponentFixture<AdminCommentsAllowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCommentsAllowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCommentsAllowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
