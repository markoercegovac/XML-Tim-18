import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCarClassComponent } from './create-car-class.component';

describe('CreateCarClassComponent', () => {
  let component: CreateCarClassComponent;
  let fixture: ComponentFixture<CreateCarClassComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCarClassComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCarClassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
