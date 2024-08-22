package com.ttma.eventBlog.controller;

import com.ttma.eventBlog.Service.PostService;
import com.ttma.eventBlog.dto.request.PostRequest;
import com.ttma.eventBlog.dto.request.UserRequest;
import com.ttma.eventBlog.dto.response.ResponseData;
import com.ttma.eventBlog.dto.response.ResponseError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/post")
@Slf4j
public class PostController {
    private final PostService postService;
    @PostMapping("/create")
    public ResponseData<?> createPost(@RequestBody PostRequest request){
        try{
            return new ResponseData<>(HttpStatus.OK.value(), "success",postService.createPost(request));
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
    @GetMapping("/list")
    public ResponseData<?> getAllPost(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                      @RequestParam(defaultValue = "20", required = false)int pageSize){
        try{
            return new ResponseData<>(HttpStatus.OK.value(), "success",postService.getAllPost(pageNo, pageSize));
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
    @GetMapping("/detail/{id}")
    public ResponseData<?> getCateById(@PathVariable("id") long id){
        try{
            return new ResponseData<>(HttpStatus.OK.value(), "success",postService.getPost(id));
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseData<?> updatePost(@PathVariable("id") long id, @RequestBody PostRequest request){
        try{postService.updatePost(id, request);
            return new ResponseData<>(HttpStatus.OK.value(), "success");
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseData<?> deletePost(@PathVariable("id") long id){
        try{
            postService.deletePost(id);
            return new ResponseData<>(HttpStatus.OK.value(), "success");
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
}
