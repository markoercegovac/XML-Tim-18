import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestsBundleComponent } from './requests-bundle.component';

describe('RequestsBundleComponent', () => {
  let component: RequestsBundleComponent;
  let fixture: ComponentFixture<RequestsBundleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestsBundleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestsBundleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
