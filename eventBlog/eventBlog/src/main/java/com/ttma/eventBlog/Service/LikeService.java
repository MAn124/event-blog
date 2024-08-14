package com.ttma.eventBlog.Service;

import com.ttma.eventBlog.dto.request.LikeRequest;
import com.ttma.eventBlog.model.Like;

public interface LikeService {
    Like createLike(LikeRequest request);

}
