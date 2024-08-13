import { Component } from '@angular/core';
import { PostService } from '../../../core/service/post.service';
import { Post } from '../../../core/interface/post';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrl: './feed.component.css'
})
export class FeedComponent {
  posts: Post[] = [];
  post: Post = {};
  isVisible: boolean = false;
  isEditable: boolean = false;
  constructor(

    private postService: PostService,

  ) {}
  ngOnInit() {
    this.getPosts();
  }

  getPosts() {
    this.postService.getAllPosts().subscribe({
      next: (posts) => {
        this.posts = posts;
        console.log(this.posts);
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

}
