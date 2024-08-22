package com.ttma.eventBlog.Service;

import com.ttma.eventBlog.dto.request.PostRequest;
import com.ttma.eventBlog.dto.request.UserRequest;
import com.ttma.eventBlog.dto.response.ResponsePost;
import com.ttma.eventBlog.dto.response.ResponseUser;
import com.ttma.eventBlog.model.Post;


import java.util.List;

public interface PostService {
    long createPost(PostRequest request);
    List<ResponsePost> getAllPost(int pageNo, int pageSize);
    ResponsePost getPost(long id);
    void updatePost(long id, PostRequest request);
    void deletePost(long id);

}
