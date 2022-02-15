package com.example.springcrud.security;

public enum Permission {

    REALTOR_READ("realtor:read"),
    REALTOR_WRITE("realtor:write"),
    APARTMENT_READ("apartment:read"),
    APARTMENT_WRITE("apartment:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
