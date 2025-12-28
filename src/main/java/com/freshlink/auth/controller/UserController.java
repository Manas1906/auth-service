package com.freshlink.auth.controller;

import com.freshlink.auth.dto.UserProfileResponse;
import com.freshlink.auth.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AuthService service;
    @GetMapping("/profile")
    public String profile(Authentication auth) {
        return "Logged in as: " + auth.getName();
    }
    @GetMapping("/me")
    public UserProfileResponse myProfile(Authentication auth) {
        return service.getProfile(auth.getName());
    }
    public UserController(AuthService service){
        this.service = service;
    }
}
