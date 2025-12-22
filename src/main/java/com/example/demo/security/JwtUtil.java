package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        return "dummy-token";
    }

    public String extractUsername(String token) {
        return "user";
    }

    public boolean validateToken(String token, String username) {
        return true;
    }
}
