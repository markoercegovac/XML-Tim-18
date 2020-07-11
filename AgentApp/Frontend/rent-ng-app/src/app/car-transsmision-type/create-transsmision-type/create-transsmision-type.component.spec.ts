import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTranssmisionTypeComponent } from './create-transsmision-type.component';

describe('CreateTranssmisionTypeComponent', () => {
  let component: CreateTranssmisionTypeComponent;
  let fixture: ComponentFixture<CreateTranssmisionTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateTranssmisionTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTranssmisionTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
