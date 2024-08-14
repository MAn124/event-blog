import { Injectable } from '@angular/core';
import { BASE_URL } from '../config/config';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Like } from '../interface/like';

@Injectable({
  providedIn: 'root'
})
export class LikeService {
  private apiLike = BASE_URL + '/likes'
  constructor(private http: HttpClient) { }

  toggleLike(postId: string):Observable<Like>{
    return this.http.post<Like>(`${this.apiLike}`, postId);
  }
}
