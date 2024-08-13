package com.ttma.eventBlog.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Builder
public class ResponsePost {
    private Long id;
    private String title;
    private String content;
    private Set<String> tags;
    private LocalDateTime createAt;
    private Long createBy;
}
