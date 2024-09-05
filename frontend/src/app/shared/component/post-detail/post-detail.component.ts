import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PostService } from '../../../core/service/post.service';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrl: './post-detail.component.css'
})
export class PostDetailComponent {
  postId: string = '';
  post: any= {};
  constructor(private activeRoute: ActivatedRoute,
    private postService: PostService ,
  
  ){}
  ngOnInit(){
    console.log('ngOnInit called');
    this.postId = this.activeRoute.snapshot.paramMap.get('id') || '';
    console.log('Post ID:', this.postId);
    this.getPost(this.postId);
  }
  getPost(id: string){
    this.postService.getPost(id).subscribe({
      next:(post) => {
        console.log('Post data:', post);
        this.post = post.data;
       
      },
      error: (error) => {
        console.log('No post data received');
      }
    })
  }
}
