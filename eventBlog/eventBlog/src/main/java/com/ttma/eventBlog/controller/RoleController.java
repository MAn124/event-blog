package com.ttma.eventBlog.controller;

import com.ttma.eventBlog.Service.RoleService;
import com.ttma.eventBlog.dto.request.RoleRequest;
import com.ttma.eventBlog.dto.response.ResponseData;
import com.ttma.eventBlog.dto.response.ResponseError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/role")
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseData<?> createRole(@RequestBody RoleRequest request){
        try{
            return new ResponseData<>(HttpStatus.CREATED.value(), "success",roleService.createRole(request));
        } catch (Exception e){
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Failed");
        }
    }
    @GetMapping("/list")
    public ResponseData<?> getAllRole(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                      @RequestParam(defaultValue = "20", required = false)int pageSize){
        try {
            return new ResponseData<>(HttpStatus.OK.value(), "success",roleService.getAllRole(pageNo, pageSize));
        } catch (Exception e){
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Failed");
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseData<?> deleteRole(@PathVariable("id" )long id){
        try {
            roleService.deleteRole(id);
            return new ResponseData<>(HttpStatus.OK.value(), "success");
        } catch (Exception e){
            return new ResponseError(HttpStatus.NO_CONTENT.value(), "Failed");
        }
    }
    @PatchMapping("/update/{id}")
    public ResponseData<?> updateRole(@PathVariable("id") long id,
                                      @RequestBody RoleRequest request){
        try {
            return new ResponseData<>(HttpStatus.OK.value(), "success",roleService.updateRole(id, request));
        }catch (Exception e){
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Failed");
        }
    }
}
