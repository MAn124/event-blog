package com.ttma.eventBlog.repository;

import com.ttma.eventBlog.dto.response.ResponseUser;
import com.ttma.eventBlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    ResponseUser findByFirstName(String firstName);
}
