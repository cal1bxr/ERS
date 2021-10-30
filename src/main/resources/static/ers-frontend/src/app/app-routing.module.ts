import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { ReimbFormComponent } from './components/reimb-form/reimb-form.component';
import { ReimbManangerFormComponent } from './components/reimb-mananger-form/reimb-mananger-form.component';
import { ReimbTableComponent } from './components/reimb-table/reimb-table.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserTableComponent } from './components/user-table/user-table.component';

const routes: Routes = [
  {path: '',   redirectTo: '/login', pathMatch: 'full'}, 
  {path: 'login', component: LoginFormComponent},
  {path: 'employee', component: EmployeeComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'empform', component: ReimbFormComponent},
  {path: 'adminform', component: ReimbManangerFormComponent},
  {path: 'user', component:UserFormComponent},
  {path: 'usertable', component:UserTableComponent},
  {path: 'reimbtable', component: ReimbTableComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
