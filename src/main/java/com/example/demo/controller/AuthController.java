package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setEmployeeId(request.getEmployeeId());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        userService.createUser(user);
        return "User registered";
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        UserAccount user = userService.findByUsername(request.getUsernameOrEmail());

        String token = jwtUtil.generateToken(user.getUsername());

        JwtResponse response = new JwtResponse(token);
        response.setUserId(user.getId());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());

        return response;
    }
}
