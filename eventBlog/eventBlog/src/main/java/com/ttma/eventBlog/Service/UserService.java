package com.ttma.eventBlog.Service;

import com.ttma.eventBlog.dto.request.UserRequest;
import com.ttma.eventBlog.dto.response.ResponseUser;
import com.ttma.eventBlog.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    User createUser(UserRequest request);
    List<ResponseUser> getAllUser(int pageNo, int pageSize);
    User getUserById(long id);
    User updateUser(long id, UserRequest request);
    void deleteUser(long id);
}
