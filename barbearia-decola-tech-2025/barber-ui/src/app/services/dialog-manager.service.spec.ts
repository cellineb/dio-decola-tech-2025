import { TestBed } from '@angular/core/testing';

import { DialogManagerService } from './dialog-manager.service';

describe('DialogManagerService', () => {
  let service: DialogManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DialogManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
