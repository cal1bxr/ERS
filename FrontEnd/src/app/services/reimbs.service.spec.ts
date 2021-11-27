import { TestBed } from '@angular/core/testing';

import { ReimbsService } from './reimbs.service';

describe('ReimbsService', () => {
  let service: ReimbsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReimbsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
