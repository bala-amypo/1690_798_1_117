package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository violationRepo;

    public ViolationRecordServiceImpl(ViolationRecordRepository violationRepo) {
        this.violationRepo = violationRepo;
    }

    public ViolationRecord logViolation(ViolationRecord violation) {
        return violationRepo.save(violation);
    }

    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return violationRepo.findByUserId(userId);
    }

    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = violationRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Violation not found"));
        record.setResolved(true);
        return violationRepo.save(record);
    }

    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }

    public List<ViolationRecord> getAllViolations() {
        return violationRepo.findAll();
    }
}
