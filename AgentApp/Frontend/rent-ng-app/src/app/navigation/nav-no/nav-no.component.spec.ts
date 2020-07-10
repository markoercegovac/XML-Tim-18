import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavNoComponent } from './nav-no.component';

describe('NavNoComponent', () => {
  let component: NavNoComponent;
  let fixture: ComponentFixture<NavNoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavNoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavNoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
