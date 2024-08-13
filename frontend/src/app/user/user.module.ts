import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user.component';
import { FeedComponent } from './component/feed/feed.component';
import { SharedModule } from '../shared/shared.module';
import { PrimeNgModule } from '../primeng.modules';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { PostDetailComponent } from '../shared/component/post-detail/post-detail.component';

const routes: Routes = [
  {
    path: '',
    component: FeedComponent,
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
  declarations: [
    UserComponent,
    FeedComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    PrimeNgModule,
    FormsModule,
    RouterModule.forChild(routes)
  ]
})
export class UserModule { }
