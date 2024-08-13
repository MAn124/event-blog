package com.ttma.eventBlog.dto.request;

import com.ttma.eventBlog.model.Role;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String lastName;
    private String firstName;
    private String email;
    private String username;
    private String password;
    private boolean active;
    private Integer role;
}
