import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpInterceptorFn, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';
import { AuthService } from '../service/auth.service';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
  constructor(
    private router: Router,
    private authService: AuthService
  ){

  }
  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token = this.authService.getToken();
    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        if(token &&(error.status === 401 || error.status === 403)){
          if(error.error.message === 'JWT expired') {
            this.authService.removeUsername();
            this.authService.removeToken();
          }
            this.router.navigate(['/login'], {
              queryParams:{message: error.status === 403 ? 'Session Expired' : 'Authorized'}
            });
        } else if(error.status === 404){
          this.router.navigate(['/404']);
        }
        return throwError(() => error)
      })
    );
  return next.handle(request);
  }
}