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
  login(credentials: {username: any, password: any}):Observable<any>{
    const headers = { 'Content-Type': 'application/json' };
    return  this.http.post<any>(this.apiUrl,credentials,{headers})
  }
  
  setToken(token: string){
    window.localStorage.setItem("authToken",token);
  }
  getToken(): string {
    return window.localStorage.getItem("authToken") || "";
  }
  /**
   * 
   * @returns 
   */
  removeToken(): void {
    return window.localStorage.removeItem("authToken");
  }

  /**
   * 
   * 
   */
  setUsername(username: string){
    window.localStorage.setItem("currentUsername",username);
  }
  getUsername(): string {
    return window.localStorage.getItem("currentUsername") || "";
  }
  /**
   * 
   *
   */
  removeUsername(): void {
    return window.localStorage.removeItem("currentUsername");
  }
  canActive(): boolean {
    return !!this.getToken();
  }
}

