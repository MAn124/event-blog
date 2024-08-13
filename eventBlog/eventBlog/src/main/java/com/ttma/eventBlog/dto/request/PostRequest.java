package com.ttma.eventBlog.dto.request;

import com.ttma.eventBlog.model.User;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequest {
    private String title;
    private String content;
    private Set<String> tags = new HashSet<>();
    private Long createBy;
}
