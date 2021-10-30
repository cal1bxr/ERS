import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { AdminComponent } from './components/admin/admin.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ReimbFormComponent } from './components/reimb-form/reimb-form.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { ReimbTableComponent } from './components/reimb-table/reimb-table.component';
import { UserTableComponent } from './components/user-table/user-table.component';
import { ReimbManangerFormComponent } from './components/reimb-mananger-form/reimb-mananger-form.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    AdminComponent,
    NavbarComponent,
    ReimbFormComponent,
    UserFormComponent,
    LoginFormComponent,
    ReimbTableComponent,
    UserTableComponent,
    ReimbManangerFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
