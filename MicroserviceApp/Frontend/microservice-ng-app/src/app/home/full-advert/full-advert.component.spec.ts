import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FullAdvertComponent } from './full-advert.component';

describe('FullAdvertComponent', () => {
  let component: FullAdvertComponent;
  let fixture: ComponentFixture<FullAdvertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FullAdvertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FullAdvertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
