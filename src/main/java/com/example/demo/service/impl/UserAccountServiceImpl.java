package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.stereotype.Service;
@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;

    public UserAccountServiceImpl(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserAccount createUser(UserAccount user) {
        if (user.getStatus() == null) user.setStatus("ACTIVE");
        user.setCreatedAt(LocalDateTime.now());
        return userRepo.save(user);
    }

    public UserAccount getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = getUserById(id);
        user.setStatus(status);
        return userRepo.save(user);
    }

    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<UserAccount> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
