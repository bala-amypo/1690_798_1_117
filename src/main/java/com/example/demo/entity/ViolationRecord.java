package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long policyRuleId;
    private Long eventId;
    private String violationType;
    private String details;
    private String severity;
    private Boolean resolved;
    private LocalDateTime detectedAt;

    @PrePersist
    public void onCreate() {
        detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    // getters and setters
}
