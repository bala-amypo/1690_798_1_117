package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    @PostMapping("/record")
    public ResponseEntity<LoginEvent> record(@RequestBody LoginEvent event) {
        return ResponseEntity.ok(service.recordLogin(event));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginEvent>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getEventsByUser(userId));
    }

    @GetMapping("/suspicious/{userId}")
    public ResponseEntity<List<LoginEvent>> suspicious(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getSuspiciousLogins(userId));
    }

    @GetMapping
    public ResponseEntity<List<LoginEvent>> all() {
        return ResponseEntity.ok(service.getAllEvents());
    }
}
