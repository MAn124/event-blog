import { Component } from '@angular/core';
import { AuthService } from '../core/service/auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  currentUser: string = '';

  constructor(private authService: AuthService){

  }
  ngOnInit(){this.getCurrentUsername()}

  getCurrentUsername(){
   this.currentUser = this.authService.getUsername();
  }
}
