package com.HarmyFounder.HItxt.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.POSTS_READ, Permission.POSTS_WRITE)),
    ADMIN(Set.of(Permission.POSTS_READ ,Permission.POSTS_WRITE, Permission.POSTS_MODERATE));

    private Set<Permission> permission;

    Role(Set<Permission> permission) {
        this.permission = permission;
    }

    public Set<Permission> getPermission() {
        return permission;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermission().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
    }

}
