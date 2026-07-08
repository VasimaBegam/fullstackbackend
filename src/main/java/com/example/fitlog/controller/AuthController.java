package com.example.fitlog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitlog.entity.SystemAccount;
import com.example.fitlog.service.AuthService;
import com.example.fitlog.service.Jwtservice;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final Jwtservice jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;

    public AuthController(Jwtservice jwtService,
                          AuthenticationManager authenticationManager,
                          AuthService authService) {

        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SystemAccount user) {

        try {

            authService.register(user);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Registration Successful");

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            Map<String, String> errStmt = new HashMap<>();

            if (e.getMessage() != null &&
                e.getMessage().toLowerCase().contains("duplicate")) {

                errStmt.put("message", "Email id already registered");

            } else {

                errStmt.put("message", "Registration Failed");
            }

            return ResponseEntity.badRequest().body(errStmt);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SystemAccount user) {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            user.getPassword()
                    ));

            String token = jwtService.generateToken(user.getEmail());

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login Successful");
            response.put("token", token);

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Invalid Email or Password");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(response);
        }
    }
}