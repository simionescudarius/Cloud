import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeetingsRequestsComponent } from './meetings-requests.component';

describe('MeetingsRequestsComponent', () => {
  let component: MeetingsRequestsComponent;
  let fixture: ComponentFixture<MeetingsRequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeetingsRequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeetingsRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
