package com.example.spring.repository;

import com.example.spring.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount , Integer> {
     Optional<UserAccount> findByUsername( String username);
        Boolean existsByUsername(String username);
    }

