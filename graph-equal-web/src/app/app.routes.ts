import {Routes} from '@angular/router';
import {authGuard} from './auth/auth-guard';
import {Login} from './login/login';
import {UserComponent} from './user/user-component';

export const routes: Routes = [
  {path: '', component: UserComponent, canActivate: [authGuard]},
  {path: 'login', component: Login, title: 'Login'},
];
