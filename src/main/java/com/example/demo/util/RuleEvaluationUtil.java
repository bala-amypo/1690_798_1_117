package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

import java.time.LocalDateTime;
import java.util.List;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    /**
     * Evaluate login events against active policy rules.
     * Current test-driven rule:
     * If loginStatus matches conditionsJson, a violation is created.
     */
    public void evaluateLoginEvent(LoginEvent event) {

        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();

        if (activeRules == null || activeRules.isEmpty()) {
            return;
        }

        for (PolicyRule rule : activeRules) {

            if (rule.getConditionsJson() == null) {
                continue;
            }

            if (event.getLoginStatus() != null &&
                    rule.getConditionsJson().contains(event.getLoginStatus())) {

                ViolationRecord violation = new ViolationRecord();
                violation.setUserId(event.getUserId());
                violation.setEventId(event.getId());
                violation.setViolationType("LOGIN_RULE_VIOLATION");
                violation.setDetails("Rule matched: " + rule.getRuleCode());
                violation.setSeverity(rule.getSeverity());
                violation.setDetectedAt(LocalDateTime.now());
                violation.setResolved(false);

                violationRepo.save(violation);
            }
        }
    }
}
