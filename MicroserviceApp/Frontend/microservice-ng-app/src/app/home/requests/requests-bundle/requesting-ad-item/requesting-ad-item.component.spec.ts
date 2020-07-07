import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestingAdItemComponent } from './requesting-ad-item.component';

describe('RequestingAdItemComponent', () => {
  let component: RequestingAdItemComponent;
  let fixture: ComponentFixture<RequestingAdItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestingAdItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestingAdItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
