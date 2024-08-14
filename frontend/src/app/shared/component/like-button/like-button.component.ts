import { Component, Input } from '@angular/core';
import { LikeService } from '../../../core/service/like.service';

@Component({
  selector: 'app-like-button',
  templateUrl: './like-button.component.html',
  styleUrl: './like-button.component.css'
})
export class LikeButtonComponent {
  @Input() postId!: string;
  isLiked: boolean = false;
  constructor(private likeService: LikeService){}
  ngOnInit(){
    this.getIsLiked();
  }
  getIsLiked(){

  }
  toggleLike(){
    this.likeService.toggleLike(this.postId).subscribe({
      next: (isLiked) => {
        console.log(isLiked);
      },
      error: (error) => {
        console.log(error);
      }
    })
  }
}
