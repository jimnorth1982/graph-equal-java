import {inject} from '@angular/core';
import {CanActivateFn, Router} from '@angular/router';
import {AuthService} from './auth.service';
import {map} from 'rxjs/operators';

export const authGuard: CanActivateFn = (_, __) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  return authService.isLoggedIn().pipe(
    map(isLoggedIn => {
      if (isLoggedIn) {
        return true;
      } else {
        // Redirect to the login page if not logged in
        return router.createUrlTree(['/login']);
      }
    })
  );
};
