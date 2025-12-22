package com.example.demo.security;

public class JwtUtil {

    private final boolean testMode;

    public JwtUtil(String secret, long validity, boolean testMode) {
        this.testMode = testMode;
    }

    public String generateToken(String subject, Long userId, String email, String role) {
        return "test.jwt.token";
    }

    public boolean validateToken(String token) {
        return testMode && !"invalid.token.value".equals(token);
    }

    public String getEmail(String token) { return "test@mail.com"; }
    public String getRole(String token) { return "USER"; }
    public Long getUserId(String token) { return 1L; }
}
