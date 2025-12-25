package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key;
    private final long validityInMs;
    private final boolean testMode;

    // ✅ REQUIRED BY TESTS
    public JwtUtil(String secret, long validityInMs, boolean testMode) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.validityInMs = validityInMs;
        this.testMode = testMode;
    }

    // ✅ DEFAULT CONSTRUCTOR FOR SPRING
    public JwtUtil() {
        this("mysecretkeymysecretkeymysecretkey", 3600000, false);
    }

    // ✅ USED BY AuthController
    public String generateToken(String username, Long userId, String role, String email) {

        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .claim("role", role)
                .claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ REQUIRED BY TESTS
    public boolean validateToken(String token) {
        try {
            getAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ REQUIRED BY TESTS
    public String getEmail(String token) {
        return getAllClaims(token).get("email", String.class);
    }

    // ✅ REQUIRED BY TESTS
    public String getRole(String token) {
        return getAllClaims(token).get("role", String.class);
    }

    // ✅ REQUIRED BY TESTS
    public Long getUserId(String token) {
        return getAllClaims(token).get("userId", Long.class);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
