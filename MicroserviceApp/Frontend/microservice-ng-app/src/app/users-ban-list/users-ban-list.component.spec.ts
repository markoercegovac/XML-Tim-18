import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersBanListComponent } from './users-ban-list.component';

describe('UsersBanListComponent', () => {
  let component: UsersBanListComponent;
  let fixture: ComponentFixture<UsersBanListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsersBanListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersBanListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
