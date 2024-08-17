package com.ttma.eventBlog.controller;

import com.ttma.eventBlog.Service.AuthenticateService;
import com.ttma.eventBlog.dto.request.LoginRequest;
import com.ttma.eventBlog.dto.response.ResponseError;
import com.ttma.eventBlog.dto.response.ResponseToken;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthenticateService authenticateService;
    @PostMapping("/login")
    public ResponseEntity<ResponseToken> login(@RequestBody LoginRequest request){
        try{
            return new ResponseEntity<>(authenticateService.authenticate(request), HttpStatus.OK);
        } catch (Exception e){
            log.error("error message: {}",e.getMessage(),e.getCause());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/refresh")
    public  ResponseEntity<ResponseToken> refresh(HttpServletRequest request){
        return new ResponseEntity<>(authenticateService.refresh(request),HttpStatus.OK);
    }
}
