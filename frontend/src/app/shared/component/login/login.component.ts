import { Component } from '@angular/core';
import { AuthService } from '../../../core/service/auth.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  login : any = {username: '', password: ''}
  message: string = '';
  constructor(private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute
  ){}
  ngOnInit(){
      this.route.queryParams.subscribe(params =>{
        this.message = params['message'];
      })
  }
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
