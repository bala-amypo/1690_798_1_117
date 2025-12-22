package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository ruleRepo;

    public PolicyRuleServiceImpl(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    public PolicyRule createRule(PolicyRule rule) {
        return ruleRepo.save(rule);
    }

    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = ruleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setConditionsJson(rule.getConditionsJson());
        existing.setActive(rule.getActive());
        return ruleRepo.save(existing);
    }

    public List<PolicyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    public PolicyRule getRuleByCode(String ruleCode) {
        return ruleRepo.findByRuleCode(ruleCode)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }

    public List<PolicyRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
