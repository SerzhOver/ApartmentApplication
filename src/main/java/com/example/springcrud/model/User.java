package com.example.springcrud.model;

import com.example.springcrud.entity.RoleEntity;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private String username;
    private String password;
    private Set<RoleEntity> roles;
}