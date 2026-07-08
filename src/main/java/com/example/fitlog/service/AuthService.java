package com.example.fitlog.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fitlog.entity.SystemAccount;
import com.example.fitlog.repository.SystemAccountRepository;

@Service
public class AuthService {

    private final PasswordEncoder encoder;
    private final SystemAccountRepository repo;
    private final Jwtservice jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(PasswordEncoder encoder,
                       SystemAccountRepository repo,
                       Jwtservice jwtService,
                       AuthenticationManager authenticationManager) {

        this.encoder = encoder;
        this.repo = repo;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // Register
    public SystemAccount register(SystemAccount user) {

        user.setPassword(encoder.encode(user.getPassword()));

        return repo.save(user);
    }

    // Login
    public ResponseEntity<?> login(SystemAccount user) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()));

        String token = jwtService.generateToken(user.getEmail());

        Map<String, Object> response = new HashMap<>();

        response.put("message", "Login Successful");
        response.put("token", token);

        return ResponseEntity.ok(response);
    }

    // Verify Password
    public boolean verifyPassword(String email, String password) {

        SystemAccount user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        return encoder.matches(password, user.getPassword());
    }
}