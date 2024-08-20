package com.ttma.eventBlog.Service;

import com.ttma.eventBlog.dto.request.RoleRequest;
import com.ttma.eventBlog.dto.response.ResponseRole;
import com.ttma.eventBlog.model.Role;

import java.util.List;

public interface RoleService {
    List<ResponseRole> getAllRole(int pageNo, int pageSize);
    Role createRole(RoleRequest request);
    void deleteRole(long id);
    Role updateRole(long id, RoleRequest request);

}
