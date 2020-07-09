import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriveReportCreateComponent } from './drive-report-create.component';

describe('DriveReportCreateComponent', () => {
  let component: DriveReportCreateComponent;
  let fixture: ComponentFixture<DriveReportCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriveReportCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriveReportCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
