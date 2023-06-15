package com.HarmyFounder.HItxt.models;

public enum Permission {
    POSTS_READ("posts:read"),
    POSTS_WRITE("posts:write"),
    POSTS_MODERATE("posts:moderate");
    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
