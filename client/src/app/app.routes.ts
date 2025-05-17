import { Routes } from '@angular/router';
import {LoginComponent} from './shared/login/login.component';
import {MainwindowComponent} from './shared/mainwindow/mainwindow.component';
import {HomeComponent} from './shared/home/home.component';
import {authenticationGuard} from './utils/guards/authentication.guard';
import {EmployeeComponent} from './modules/employee/employee.component';
import {UserComponent} from './modules/user/user.component';
import {AccessComponent} from './modules/access/access.component';

export const routes: Routes = [
  { path: "login", component: LoginComponent, title: 'Login' },
  { path: "", redirectTo:"login" ,pathMatch:"full"},
  {
    path: "main",
    component: MainwindowComponent,
    canActivate:[authenticationGuard],
    children: [
      { path: "home", component: HomeComponent, title: 'Home' },

      { path: "employee", component: EmployeeComponent, title: 'Employee' },
      { path: "user", component: UserComponent, title: 'User' },
      { path: "access", component: AccessComponent, title: 'Access' },
    ]
  }
];
