package com.ttma.eventBlog.dto.request;

import com.ttma.eventBlog.model.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequest {
    @NotEmpty(message = "Last name is empty")
    @Length(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;
    @NotEmpty(message = "Content is empty")
    @Length(min = 50,  message = "Title must be between 1 and 100 characters")
    private String content;
    @NotEmpty(message = "Tag is empty")
    private Set<String> tags = new HashSet<>();
    private Long createBy;
}
