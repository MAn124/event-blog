package com.ttma.eventBlog.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseUser {
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String username;
    private String password;
    private boolean active;
    private Integer role;
}
