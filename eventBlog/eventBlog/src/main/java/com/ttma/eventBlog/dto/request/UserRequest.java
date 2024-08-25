package com.ttma.eventBlog.dto.request;

import com.ttma.eventBlog.model.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotEmpty(message = "Last name is empty")
    @Length(min = 1, max = 100, message = "Last name must be between 1 and 100 characters")
    private String lastName;
    @NotEmpty(message = "First name is empty")
    @Length(min = 1, max = 100, message = "First name must be between 1 and 100 characters")
    private String firstName;
    @NotEmpty(message = "Email is empty")
    @Email(message = "Not email format")
    private String email;
    @NotEmpty(message = "Username is empty")
    @Length(min = 1, max = 100, message = "Username must be between 1 and 100 characters")
    private String username;
    @NotEmpty(message = "Password is empty")
    private String password;
    private boolean active;
    private Integer role;
}
