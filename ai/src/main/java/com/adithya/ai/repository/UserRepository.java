package com.adithya.ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adithya.ai.service.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
