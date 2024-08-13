package com.ttma.eventBlog.dto.request;

import com.ttma.eventBlog.enums.RoleEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoleRequest {
    private RoleEnum name;
    private String description;
}
