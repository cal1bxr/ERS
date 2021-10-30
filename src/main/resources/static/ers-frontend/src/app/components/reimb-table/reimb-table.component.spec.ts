import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbTableComponent } from './reimb-table.component';

describe('ReimbTableComponent', () => {
  let component: ReimbTableComponent;
  let fixture: ComponentFixture<ReimbTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReimbTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
