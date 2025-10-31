package com.adithya.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.adithya.ai.repository.UserRepository;
import com.adithya.ai.service.User;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> userData) {
        if (userRepository.findByEmail(userData.get("email")).isPresent())
            return ResponseEntity.badRequest().body("Email already registered");
        if (userRepository.findByUsername(userData.get("username")).isPresent())
            return ResponseEntity.badRequest().body("Username already registered");
        User user = new User();
        user.setEmail(userData.get("email"));
        user.setUsername(userData.get("username"));
        user.setPassword(passwordEncoder.encode(userData.get("password")));
        userRepository.save(user);
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        User user = userRepository.findByEmail(loginData.get("email")).orElse(null);
        if (user == null || !passwordEncoder.matches(loginData.get("password"), user.getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        return ResponseEntity.ok("Login successful");
        // For real apps, generate and return JWT here
    }
}
