import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriveReportUpdateComponent } from './drive-report-update.component';

describe('DriveReportUpdateComponent', () => {
  let component: DriveReportUpdateComponent;
  let fixture: ComponentFixture<DriveReportUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriveReportUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriveReportUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
