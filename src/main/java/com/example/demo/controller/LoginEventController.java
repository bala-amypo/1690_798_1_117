package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    LoginEventService loginService;   

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/record")
    public LoginEvent recordLogin(@RequestBody LoginEvent event) {
        return loginService.recordLogin(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getByUser(@PathVariable Long userId) {
        return loginService.getEventsByUser(userId);
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> getSuspicious(@PathVariable Long userId) {
        return loginService.getSuspiciousLogins(userId);
    }

    @GetMapping
    public List<LoginEvent> getAll() {
        return loginService.getAllEvents();
    }
}
