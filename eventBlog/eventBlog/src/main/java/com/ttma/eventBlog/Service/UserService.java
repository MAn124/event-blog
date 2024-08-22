package com.ttma.eventBlog.Service;

import com.ttma.eventBlog.dto.request.UserRequest;
import com.ttma.eventBlog.dto.response.ResponseUser;
import com.ttma.eventBlog.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    long createUser(UserRequest request);
    List<ResponseUser> getAllUser(int pageNo, int pageSize);
    ResponseUser getUser(long id);
    void updateUser(long id, UserRequest request);
    void deleteUser(long id);
}
