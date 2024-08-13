import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StaffComponent } from './staff/staff.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './shared/component/login/login.component';

const routes: Routes = [
  {
    path:'',
    component: UserComponent,
    loadChildren:() =>
      import('./user/user.module').then(e => e.UserModule)
    },
    {
    path:'staff',
    component: StaffComponent,
    loadChildren:() =>
      import('./staff/staff.module').then(e => e.StaffModule)
    },
    {
      path:'login',
      component: LoginComponent,
      title:'Login'
    }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
