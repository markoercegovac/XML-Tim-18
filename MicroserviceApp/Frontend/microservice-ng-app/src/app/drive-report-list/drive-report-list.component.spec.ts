import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriveReportListComponent } from './drive-report-list.component';

describe('DriveReportListComponent', () => {
  let component: DriveReportListComponent;
  let fixture: ComponentFixture<DriveReportListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriveReportListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriveReportListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
