package com.example.demo.repository;

import com.example.demo.entity.LoginEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginEventRepository
        extends JpaRepository<LoginEvent, Long> {
}
