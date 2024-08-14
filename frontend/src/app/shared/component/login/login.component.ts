import { Component } from '@angular/core';
import { AuthService } from '../../../core/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  login : any ={email: '', password: ''}
  constructor(private authService: AuthService){}
  onLogin(){
    this.authService.login(this.login).subscribe({
      next: (data) => {
        console.log('Login successful:', data);
      },
      error: (error) => {
        console.log(error);
      }
    })
  }
}
