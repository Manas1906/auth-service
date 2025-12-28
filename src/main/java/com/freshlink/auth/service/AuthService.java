package com.freshlink.auth.service;



import com.freshlink.auth.dto.LoginRequest;
import com.freshlink.auth.dto.RegisterRequest;
import com.freshlink.auth.dto.UserProfileResponse;
import com.freshlink.auth.model.User;
import com.freshlink.auth.repository.UserRepository;
import com.freshlink.auth.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository repo, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public String register(RegisterRequest req) {
        if (repo.findByEmail(req.getEmail()).isPresent())
            throw new RuntimeException("User already exists");

        User u = new User();
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setPassword(encoder.encode(req.getPassword()));
        u.setRole(req.getRole());
        repo.save(u);

        return jwtUtil.generateToken(u.getEmail(), u.getRole());
    }

    public String login(LoginRequest req) {
        User user = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(req.getPassword(), user.getPassword()))
            throw new RuntimeException("Invalid password");

        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }

    public UserProfileResponse getProfile(String email) {
        User user = repo.findByEmail(email).orElseThrow();
        return new UserProfileResponse(user.getFullName(), user.getEmail(), user.getRole());
    }

}
