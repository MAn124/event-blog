package com.ttma.eventBlog.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeRequest {

    private Long userId;
    private Long postId;
}
