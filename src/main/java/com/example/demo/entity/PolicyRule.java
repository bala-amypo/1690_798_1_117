package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class PolicyRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ruleCode;
    private String description;
    private String severity;
    private String conditionsJson;
    private Boolean active;
    public PolicyRule() {
    }
    public PolicyRule(String ruleCode, String description, String severity, String conditionsJson, Boolean active) {
        this.ruleCode = ruleCode;
        this.description = description;
        this.severity = severity;
        this.conditionsJson = conditionsJson;
        this.active = active;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getRuleCode() {
        return ruleCode;
    }
    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public String getConditionsJson() {
        return conditionsJson;
    }
    public void setConditionsJson(String conditionsJson) {
        this.conditionsJson = conditionsJson;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    
}