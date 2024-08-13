package com.ttma.eventBlog.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseToken {
    private String accessToken;
    private String freshToken;
    private Long id;
}
