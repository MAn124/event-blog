import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Post } from '../../../core/interface/post';
import { User } from '../../../core/interface/user';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrl: './post.component.css'
})
export class PostComponent {
  @Input() post!: Post;
@Input() canEdit!: boolean;
@Output() isEdit = new EventEmitter();


}
