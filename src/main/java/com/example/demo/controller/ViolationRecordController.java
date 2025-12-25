package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ViolationRecord> log(@RequestBody ViolationRecord violation) {
        return ResponseEntity.ok(service.logViolation(violation));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getViolationsByUser(userId));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(service.markResolved(id));
    }

    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> unresolved() {
        return ResponseEntity.ok(service.getUnresolvedViolations());
    }

    @GetMapping
    public ResponseEntity<List<ViolationRecord>> all() {
        return ResponseEntity.ok(service.getAllViolations());
    }
}
