package com.ttma.eventBlog.Service.impl;

import com.ttma.eventBlog.Service.UserService;
import com.ttma.eventBlog.dto.request.UserRequest;
import com.ttma.eventBlog.dto.response.ResponseUser;
import com.ttma.eventBlog.model.User;
import com.ttma.eventBlog.repository.RoleRepository;
import com.ttma.eventBlog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetailsService userDetailsService() {
       return username -> userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("USer not found"));
    }
    @Override
    public User createUser(UserRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .active(request.isActive())
                .role(roleRepository.findById(Long.valueOf(request.getRole())).orElseThrow(() -> new RuntimeException("Role not found")))
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();
        return userRepository.save(user);
    }

    @Override
    public List<ResponseUser> getAllUser(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> users = userRepository.findAll(pageable);
        return users.map(user -> ResponseUser.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole().getId())
                .active(user.isActive())
                .build()).toList();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(long id, UserRequest request) {
        User user = getUserById(id);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setRole(roleRepository.findById(Long.valueOf(request.getRole())).orElseThrow(() -> new RuntimeException("Role not found")));
        user.setActive(request.isActive());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
