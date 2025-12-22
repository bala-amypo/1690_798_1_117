package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String severity;
    private String description;

    private boolean resolved;

    private LocalDateTime detectedAt;

    @PrePersist
    public void onCreate() {
        this.detectedAt = LocalDateTime.now();
        this.resolved = false;
    }

    // ✅ GETTERS
    public Long getId() {
        return id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }

    public boolean isResolved() {
        return resolved;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    // ✅ SETTERS
    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
