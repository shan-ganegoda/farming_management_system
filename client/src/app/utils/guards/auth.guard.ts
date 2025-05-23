import {CanActivateFn, Router} from '@angular/router';
import {inject} from '@angular/core';
import {AuthService} from '../../services/auth/auth.service';
import {TokenService} from '../../services/auth/token.service';

export const authGuard: CanActivateFn = (route, state) => {

  const authService = inject(AuthService);
  const tokenService = inject(TokenService);
  const router = inject(Router);

  tokenService.isAuthenticate.subscribe({
    next: (value) =>{
      if(!value){
        router.navigateByUrl("login");
      }
    },
  });
  return true;
};
