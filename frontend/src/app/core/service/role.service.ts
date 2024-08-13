import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BASE_URL } from '../config/config';
import { map, Observable } from 'rxjs';
import { Role } from '../interface/role';

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  private baseUrl  = 'http://localhost:8080/v1/api/role/list';

  constructor(private http: HttpClient) { }

  getAllRoles():Observable<Role[]>{
    return this.http.get<ApiResponse>(this.baseUrl).pipe(
      map(response => response.data)
    );
  }
}
interface ApiResponse {
  data: Role[];
}
