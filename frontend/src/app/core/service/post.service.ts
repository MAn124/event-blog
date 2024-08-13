import { Injectable } from '@angular/core';
import { BASE_URL } from '../config/config';
import { HttpClient } from '@angular/common/http';
import { Post } from '../interface/post';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseUrl  = BASE_URL + '/post/list';

  constructor(private http: HttpClient) { }

  // get all roles
  getAllPosts():Observable<Post[]>{
    return this.http.get<ApiResponse>(this.baseUrl).pipe(
      map(response => response.data));
  }
  getPost(id: string):Observable<ApiResponse>{
    const getUrl = `${BASE_URL}/post/detail/${id}`;
    console.log(getUrl);
    return this.http.get<ApiResponse>(getUrl)
  }
  create(post: Post):Observable<string>{
    const createUrl = BASE_URL + '/post/create';
    return this.http.post<string>(createUrl,post)
  }
  update(id: string, post: Post):Observable<string>{
    const updateUrl =`${BASE_URL}/post/update/${id}`;
    return this.http.put<string>(updateUrl, post)
  }
    delete(id: string){
      const deleteUrl = `${BASE_URL}/post/${id}`;
      return this.http.delete(deleteUrl);
    }
  
}
interface ApiResponse {
  data: Post[];
}
