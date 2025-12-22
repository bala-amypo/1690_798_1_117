package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public void createUser(UserAccount user) {
        repo.save(user);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public void updateUserStatus(Long id, String status) {
        UserAccount user = repo.findById(id).orElseThrow();
        user.setStatus(status);
        repo.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }
}
