package com.example.demo.dto;

public class JwtResponse {

    private String token;
    private Long userId;
    private String email;
    private String role;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() { return token; }
    public Long getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
}
