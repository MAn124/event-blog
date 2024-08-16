import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StaffComponent } from './staff/staff.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './shared/component/login/login.component';
import { authGuard } from './core/guard/auth.guard';
import { NotFoundComponent } from './shared/component/not-found/not-found.component';

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
    canActivate:[authGuard],
    loadChildren:() =>
      import('./staff/staff.module').then(e => e.StaffModule)
    },
    {
      path:'login',
      component: LoginComponent,
      title:'Login'
    },
    {
      path:'404',
      component: NotFoundComponent,
      title:'Page not found'
    }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
