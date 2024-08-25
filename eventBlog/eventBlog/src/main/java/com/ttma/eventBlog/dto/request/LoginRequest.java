package com.ttma.eventBlog.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
@Getter
@Builder
public class LoginRequest implements Serializable {
    @NotEmpty(message = "Username is empty")
    @Length(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String username;
    @NotEmpty(message = "Password is empty")
    @Length(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String password;
    @NotEmpty(message = "Password is empty")
    private String deviceToken;
    @NotEmpty(message = "Password is empty")
    private  String version;
}
