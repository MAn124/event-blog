package com.ttma.eventBlog.Service.impl;

import com.ttma.eventBlog.Service.RoleService;
import com.ttma.eventBlog.dto.request.RoleRequest;
import com.ttma.eventBlog.dto.response.ResponseRole;
import com.ttma.eventBlog.model.Role;
import com.ttma.eventBlog.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public List<ResponseRole> getAllRole(int pageNo, int PageSize) {
        Pageable pageable = PageRequest.of(pageNo, PageSize);
        Page<Role> roles =  roleRepository.findAll(pageable);
        return roles.map(role -> ResponseRole.builder()
                .id(role.getId())
                .name(String.valueOf(role.getName()))
                .build()).toList();
    }

    @Override
    public Role createRole(RoleRequest request) {
        Role role = Role.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role updateRole(long id, RoleRequest request) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        role.setName(request.getName());
        role.setDescription(request.getDescription());
        return roleRepository.save(role);
    }


}
