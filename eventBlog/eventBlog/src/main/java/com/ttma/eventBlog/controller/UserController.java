package com.ttma.eventBlog.controller;

import com.ttma.eventBlog.Service.UserService;
import com.ttma.eventBlog.dto.request.UserRequest;
import com.ttma.eventBlog.dto.response.ResponseData;
import com.ttma.eventBlog.dto.response.ResponseError;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/user")
@Slf4j
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    public ResponseData<?> createUser(@Valid @RequestBody UserRequest request){
        try{
            return new ResponseData<>(HttpStatus.OK.value(), "success",userService.createUser(request));
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
    @GetMapping("/list")
    public ResponseData<?> getAllCate(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                      @RequestParam(defaultValue = "20", required = false)int pageSize){
        try{
            return new ResponseData<>(HttpStatus.OK.value(), "success",userService.getAllUser(pageNo, pageSize));
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
    @GetMapping("/detail/{id}")
    public ResponseData<?> getCateById(@PathVariable("id") int id){
        try{
            return new ResponseData<>(HttpStatus.OK.value(), "success",userService.getUser(id));
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseData<?> updateCate(@PathVariable("id") long id,@Valid @RequestBody UserRequest request){
        try{
            userService.updateUser(id, request);
            return new ResponseData<>(HttpStatus.OK.value(), "success");
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseData<?> deleteCate(@PathVariable("id") long id){
        try{
            userService.deleteUser(id);
            return new ResponseData<>(HttpStatus.OK.value(), "success");
        } catch (Exception e){
            log.error("error message={}",e.getMessage(),e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "failed");
        }
    }
    @GetMapping("/search/{username}")
    public ResponseData<?> getUserByUsername(@RequestParam(required = false) String firstName){
        try{
            return new ResponseData<>(HttpStatus.OK.value(), "success",userService.findByFirstName(firstName));
        }catch (Exception e){
            return new ResponseError(HttpStatus.NOT_FOUND.value(),"User not found");
        }
    }
}
