import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationOwnerComponent } from './navigation-owner.component';

describe('NavigationOwnerComponent', () => {
  let component: NavigationOwnerComponent;
  let fixture: ComponentFixture<NavigationOwnerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavigationOwnerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigationOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
