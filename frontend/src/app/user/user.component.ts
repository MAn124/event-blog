import { Component } from '@angular/core';
import { AuthService } from '../core/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  currentUser: string = '';

  constructor(private authService: AuthService,
    private router:Router
  ){

  }
  ngOnInit(){this.getCurrentUsername()}

  getCurrentUsername(){
   this.currentUser = this.authService.getUsername();
  }
  logout(){
    this.authService.removeToken();
    this.authService.removeUsername();
    this.router.navigate(['/login']);
  }
}
