import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdRequestItemComponent } from './ad-request-item.component';

describe('AdRequestItemComponent', () => {
  let component: AdRequestItemComponent;
  let fixture: ComponentFixture<AdRequestItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdRequestItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdRequestItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
