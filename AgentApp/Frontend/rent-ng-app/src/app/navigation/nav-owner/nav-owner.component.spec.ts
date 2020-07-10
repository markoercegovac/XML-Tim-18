import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavOwnerComponent } from './nav-owner.component';

describe('NavOwnerComponent', () => {
  let component: NavOwnerComponent;
  let fixture: ComponentFixture<NavOwnerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavOwnerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
