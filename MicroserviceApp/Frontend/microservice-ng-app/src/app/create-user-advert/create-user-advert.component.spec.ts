import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateUserAdvertComponent } from './create-user-advert.component';

describe('CreateUserAdvertComponent', () => {
  let component: CreateUserAdvertComponent;
  let fixture: ComponentFixture<CreateUserAdvertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateUserAdvertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateUserAdvertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
