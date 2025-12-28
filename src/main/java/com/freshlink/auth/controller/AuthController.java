package com.freshlink.auth.controller;

import com.freshlink.auth.dto.LoginRequest;
import com.freshlink.auth.dto.RegisterRequest;
import com.freshlink.auth.model.User;
import com.freshlink.auth.repository.UserRepository;
import com.freshlink.auth.security.JwtUtil;
import com.freshlink.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {
        return service.register(req);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {
        return service.login(req);
    }
}


