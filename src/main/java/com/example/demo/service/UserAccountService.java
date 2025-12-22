package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount getUserById(Long id);

    UserAccount findByEmail(String email);

    void updateUserStatus(Long id, String status);
}
