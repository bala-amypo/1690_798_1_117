package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    void createUser(UserAccount user);

    UserAccount findByUsername(String username);

    void updateUserStatus(Long id, String status);

    List<UserAccount> getAllUsers();
}
