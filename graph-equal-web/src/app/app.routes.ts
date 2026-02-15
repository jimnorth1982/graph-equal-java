import {Routes} from '@angular/router';
import {authGuard} from './auth/auth-guard';
import {AppComponent} from './app.component';

export const routes: Routes = [
  {path: '', component: AppComponent, canActivate: [authGuard]}
];
