import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbManangerFormComponent } from './reimb-mananger-form.component';

describe('ReimbManangerFormComponent', () => {
  let component: ReimbManangerFormComponent;
  let fixture: ComponentFixture<ReimbManangerFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReimbManangerFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbManangerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
