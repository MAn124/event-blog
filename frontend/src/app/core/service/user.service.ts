import { Injectable } from '@angular/core';
import { BASE_URL } from '../config/config';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { User } from '../interface/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseUrl  = BASE_URL + '/user/list';

  constructor(private http: HttpClient) { }

  // get all roles
  getAllUsers():Observable<User[]>{
    return this.http.get<ApiResponse>(this.baseUrl).pipe(
      map(response => response.data));
  }
  getUser(id:string):Observable<User>{
    const getUserUrl = `${BASE_URL}/user/detail/${id}`;
    return this.http.get<User>(getUserUrl)
  }
  create(user: User):Observable<string>{
    const createUrl = BASE_URL + '/user/create';
    return this.http.post<string>(createUrl,user)
  }
  update(id: string, user: User):Observable<string>{
    const updateUrl =`${BASE_URL}/user/update/${id}`;
    return this.http.put<string>(updateUrl, user)
  }
    
  
}
interface ApiResponse {
  data: User[];
}
