import { TestBed } from '@angular/core/testing';

import { SnackbarManagerService } from './snackbar-manager.service';

describe('SnackbarManagerService', () => {
  let service: SnackbarManagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SnackbarManagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
