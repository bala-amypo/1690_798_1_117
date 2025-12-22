package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserAccountService userService; 

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount user) {
        return "Login successful for user: " + user.getUsername();
    }
}