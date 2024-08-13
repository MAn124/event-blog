package com.ttma.eventBlog.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseRole {
    private Integer id;
    private String name;
    private String description;
}
