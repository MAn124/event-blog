import { Component } from '@angular/core';
import { AuthService } from '../../../core/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  login : any = {username: '', password: ''}
  constructor(private authService: AuthService,
    private router: Router
  ){}
  onLogin(){
    this.authService.removeUsername();
    this.authService.removeToken();
    this.authService.login(this.login).subscribe({
      next: (data) => {
        this.authService.setUsername(this.login.username);
        this.authService.setToken(data.accessToken)
        this.router.navigate(['/']);
        console.log('Login successful:', data.accessToken);
      },
      error: (error) => {
        console.log(error);
      }
    })
  }
}
