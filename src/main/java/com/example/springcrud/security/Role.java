package com.example.springcrud.security;

import java.util.Set;

public enum Role {

    REALTOR(Set.of(Permission.APARTMENT_READ)),
    ADMIN(Set.of(Permission.APARTMENT_WRITE, Permission.REALTOR_WRITE, Permission.REALTOR_READ, Permission.APARTMENT_READ));


    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
