import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterRequestsItemComponent } from './register-requests-item.component';

describe('RegisterRequestsItemComponent', () => {
  let component: RegisterRequestsItemComponent;
  let fixture: ComponentFixture<RegisterRequestsItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterRequestsItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterRequestsItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
