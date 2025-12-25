package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PolicyRule> create(@RequestBody PolicyRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyRule> update(
            @PathVariable Long id,
            @RequestBody PolicyRule rule) {
        return ResponseEntity.ok(service.updateRule(id, rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> active() {
        return ResponseEntity.ok(service.getActiveRules());
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }
}
