import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerViewRequestsComponent } from './owner-view-requests.component';

describe('OwnerViewRequestsComponent', () => {
  let component: OwnerViewRequestsComponent;
  let fixture: ComponentFixture<OwnerViewRequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerViewRequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerViewRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
