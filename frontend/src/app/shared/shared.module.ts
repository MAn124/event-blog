import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './component/post/post.component';
import { PrimeNgModule } from '../primeng.modules';
import { CoreModule } from '../core/core.module';
import { RouterModule } from '@angular/router';
import { PostDetailComponent } from './component/post-detail/post-detail.component';
import { LoginComponent } from './component/login/login.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    PostComponent,
    PostDetailComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    PrimeNgModule,
    CoreModule,
    FormsModule,
    RouterModule
  ],
  exports:[
    PostComponent
  ]
})
export class SharedModule { }
