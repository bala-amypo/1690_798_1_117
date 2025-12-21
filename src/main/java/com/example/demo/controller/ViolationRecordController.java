package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    @PostMapping
    public ViolationRecord logViolation(@RequestBody ViolationRecord violation) {
        return violationService.logViolation(violation);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getViolationsByUser(@PathVariable Long userId) {
        return violationService.getViolationsByUser(userId);
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolveViolation(@PathVariable Long id) {
        return violationService.markResolved(id);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationService.getUnresolvedViolations();
    }

    @GetMapping
    public List<ViolationRecord> getAllViolations() {
        return violationService.getAllViolations();
    }
}
