package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    private final PolicyRuleService ruleService;

    public PolicyRuleController(PolicyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public PolicyRule createRule(@RequestBody PolicyRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public PolicyRule updateRule(@PathVariable Long id,
                                 @RequestBody PolicyRule rule) {
        return ruleService.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<PolicyRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping
    public List<PolicyRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
