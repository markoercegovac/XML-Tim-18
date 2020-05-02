import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DefinePriceComponent } from './define-price.component';

describe('DefinePriceComponent', () => {
  let component: DefinePriceComponent;
  let fixture: ComponentFixture<DefinePriceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DefinePriceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DefinePriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
