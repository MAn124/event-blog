import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { User } from '../interface/user';
import { BASE_URL } from '../config/config';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/v1/api/auth/login';
  constructor(private http: HttpClient) { }
  login(credentials: {email: any, password: any}):Observable<string>{
    const headers = { 'Content-Type': 'application/json' };
    return  this.http.post<string>(this.apiUrl,credentials,{headers})
  }
}

