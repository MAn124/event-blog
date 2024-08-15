package com.ttma.eventBlog.dto.request;

import lombok.Getter;

import java.io.Serializable;
@Getter
public class LoginRequest implements Serializable {
    private String username;
    private String password;
    private String deviceToken;
    private  String version;
}
