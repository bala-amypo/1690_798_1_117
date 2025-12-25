package com.example.demo.dto;

public class JwtResponse {

    private String token;
    private Long userId;
    private String role;
    private String email;

    public JwtResponse(String token, Long userId, String role, String email) {
        this.token = token;
        this.userId = userId;
        this.role = role;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
}
