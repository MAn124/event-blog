package com.ttma.eventBlog.model;

import com.ttma.eventBlog.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tbl_role")
public class Role  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private RoleEnum name;
    private String description;
    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();
}
