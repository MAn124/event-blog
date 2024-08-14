package com.ttma.eventBlog.Service.impl;

import com.ttma.eventBlog.Service.LikeService;
import com.ttma.eventBlog.dto.request.LikeRequest;
import com.ttma.eventBlog.model.Like;
import com.ttma.eventBlog.repository.LikeRepository;
import com.ttma.eventBlog.repository.PostRepository;
import com.ttma.eventBlog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private  final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public Like createLike(LikeRequest request) {
        Like like = Like.builder()
                .post(postRepository.findById(Long.valueOf(request.getPostId())).orElseThrow(() -> new RuntimeException("Post not found")))
                .user(userRepository.findById(Long.valueOf(request.getUserId())).orElseThrow(() -> new RuntimeException("User not found")))
                .build();
        return likeRepository.save(like);
    }
}
