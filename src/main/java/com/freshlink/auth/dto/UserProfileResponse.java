package com.freshlink.auth.dto;

import com.freshlink.auth.model.Role;

public class UserProfileResponse {
    private String fullName;
    private String email;
    private Role role;

    public UserProfileResponse(String fullName, String email, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public Role getRole() { return role; }
}
