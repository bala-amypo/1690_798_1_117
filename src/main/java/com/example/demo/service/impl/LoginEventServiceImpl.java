package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;

    public LoginEventServiceImpl(LoginEventRepository loginRepo) {
        this.loginRepo = loginRepo;
    
    }

    public LoginEvent recordLogin(LoginEvent event) {
        if (event.getIpAddress() == null || event.getDeviceId() == null)
            throw new BadRequestException("IP and Device ID required");

        LoginEvent saved = loginRepo.save(event);
        return saved;
    }

    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginRepo.findByUserId(userId);
    }

    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginRepo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    public List<LoginEvent> getAllEvents() {
        return loginRepo.findAll();
    }
}
