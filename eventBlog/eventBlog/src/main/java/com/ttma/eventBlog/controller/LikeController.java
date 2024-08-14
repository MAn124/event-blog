package com.ttma.eventBlog.controller;

import com.ttma.eventBlog.Service.LikeService;
import com.ttma.eventBlog.dto.request.LikeRequest;
import com.ttma.eventBlog.dto.response.ResponseData;
import com.ttma.eventBlog.dto.response.ResponseError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/likes")
@RequiredArgsConstructor
@Slf4j
public class LikeController {
    private final LikeService likeService;
    @PostMapping("/create")
    public ResponseData<?> createLike(@RequestBody LikeRequest request){
        try {
            return new ResponseData<>(HttpStatus.CREATED.value(), "success",likeService.createLike(request));
        }catch (Exception e){
            log.error("error message={}",e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.NO_CONTENT.value(), "Failed");
        }
    }
}
