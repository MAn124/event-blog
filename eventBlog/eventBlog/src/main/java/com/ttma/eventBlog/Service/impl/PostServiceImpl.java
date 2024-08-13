package com.ttma.eventBlog.Service.impl;

import com.ttma.eventBlog.Service.PostService;
import com.ttma.eventBlog.dto.request.PostRequest;

import com.ttma.eventBlog.dto.response.ResponsePost;
import com.ttma.eventBlog.model.Post;
import com.ttma.eventBlog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public Post createPost(PostRequest request) {
        Post post = Post.builder()
                .createBy(request.getCreateBy())
                .title(request.getTitle())
                .content(request.getContent())
                .tags(request.getTags())
                .build();
        return postRepository.save(post);
    }

    @Override
    public List<ResponsePost> getAllPost(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Post> posts  = postRepository.findAll(pageable);
        return posts.map(post -> ResponsePost.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .tags(post.getTags())
                .createBy(post.getCreateBy())
                .createAt(post.getCreateAt())
                .build()).toList();
    }

    @Override
    public Post getPostById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public Post updatePost(long id, PostRequest request) {
        Post post = getPostById(id);

        post.setTitle(request.getTitle());

        post.setContent(request.getContent());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}
