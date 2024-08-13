import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { User } from '../interface/user';
import { BASE_URL } from '../config/config';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  login(credentials: {email: any, password: any}):Observable<any>{
    return  this.http.post<any>(`${BASE_URL}/auth/login`,credentials)
  }
}
interface ApiResponse {
  data: User[];
}
