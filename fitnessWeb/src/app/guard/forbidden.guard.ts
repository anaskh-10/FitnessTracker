import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { UserStorageService } from '../service/user-storage.service';

export const forbiddenGuard: CanActivateFn = (route, state) => {
  const router=inject(Router);
  if(UserStorageService.isUserLoggedin()){
    return true;
  }else{
    router.navigateByUrl('/deniedAcces');
    return false;
  }
  
};
