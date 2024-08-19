import { Component } from '@angular/core';
import { Post } from '../../../core/interface/post';
import { ConfirmationService, MessageService } from 'primeng/api';
import { PostService } from '../../../core/service/post.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrl: './feed.component.css',
  providers: [MessageService, ConfirmationService],
})
export class FeedComponent {
  posts: Post[] = [];
  post: Post = {};
  isVisible: boolean = false;
  isEditable: boolean = false;
  constructor(
    private messageService: MessageService,
    private postService: PostService,
    private confirmationService: ConfirmationService
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
  openDialogAdd() {
    this.isEditable = false;
    this.isVisible = true;
    this.post = {};
  }
  openDialogEdit(post: any) {
    this.isEditable = true;
    this.isVisible = true;
    this.post = { ...post };
  }
  save() {
    if (this.post.id) {
      this.postService.update(this.post.id, this.post).subscribe({
        next: (id) => {
          this.isVisible = false;
          const index = this.posts.findIndex(
            (post) => post.id === this.post.id
          );
          if (index != -1) {
            this.posts[index] = this.post;
          }
          this.messageService.add({
            severity: 'success',
            summary: 'Success',
            detail: 'Message Content',
          });
        },
        error: (error) => {
          console.log(error);
        },
      });
    } else {
      this.postService.create(this.post).subscribe({
        next: (id) => {
          this.post.id = id;
          console.log(id);
          this.isVisible = false;
          this.posts.unshift({
            ...this.post,
            id: id,
            createAt: new Date().toJSON(),
            
          });
          this.posts = [...this.posts]
          this.messageService.add({
            severity: 'success',
            summary: 'Success',
            detail: 'Message Content',
          });
          console.log(this.posts);
        },
        error: (error) => {
          console.log(error);
        },
      });
    }
  }
  delete(event: Event) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Do you want to delete this record?',
      icon: 'pi pi-info-circle',
      acceptButtonStyleClass: 'p-button-danger p-button-sm',
      accept: () => {
        if (!this.post.id) return;
        this.postService.delete(this.post.id).subscribe({
          next: () => {
            this.posts = this.posts.filter(post => post.id !== this.post.id)
            this.isVisible = false;
            this.messageService.add({
              severity: 'info',
              summary: 'Confirmed',
              detail: 'Record deleted',
              life: 3000,
            });
          },
          error: (error) => {
            console.log(error);
          },
        });
      },
    });
  }
}
