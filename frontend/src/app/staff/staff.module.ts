import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StaffComponent } from './staff.component';
import { PrimeNgModule } from '../primeng.modules';
import { FeedComponent } from './component/feed/feed.component';
import { UserManagementComponent } from './component/user-management/user-management.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { UserIdToNamePipe } from '../core/pipe/user-id-to-name.pipe';
import { CoreModule } from '../core/core.module';
import { SharedModule } from '../shared/shared.module';
import { PostDetailComponent } from '../shared/component/post-detail/post-detail.component';

const routes: Routes = [
  {
    path: '',
    component: FeedComponent,
  },
  {
    path: 'user-management',
    component: UserManagementComponent,
  },
  {
    path: 'posts',
    children:[
      {
        path: ':id',
        component: PostDetailComponent,
      },
    ],
  },
];
@NgModule({
  declarations: [StaffComponent, FeedComponent, UserManagementComponent],
  imports: [
    SharedModule,
    CommonModule,
    PrimeNgModule,
    FormsModule,
    RouterModule.forChild(routes),
  ],
})
export class StaffModule {}
