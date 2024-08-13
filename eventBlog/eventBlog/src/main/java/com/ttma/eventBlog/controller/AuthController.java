package com.ttma.eventBlog.controller;

import com.ttma.eventBlog.Service.AuthenticateService;
import com.ttma.eventBlog.dto.request.LoginRequest;
import com.ttma.eventBlog.dto.response.ResponseToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticateService authenticateService;
    @PostMapping("/login")
    public ResponseEntity<ResponseToken> login(@RequestBody LoginRequest request){
        return new ResponseEntity<>(authenticateService.authenticate(request), HttpStatus.OK);
    }
}
