import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationUnregistatedComponent } from './navigation-unregistated.component';

describe('NavigationUnregistatedComponent', () => {
  let component: NavigationUnregistatedComponent;
  let fixture: ComponentFixture<NavigationUnregistatedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavigationUnregistatedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigationUnregistatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
