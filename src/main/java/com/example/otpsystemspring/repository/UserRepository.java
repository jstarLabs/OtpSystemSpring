package com.example.otpsystemspring.repository;

import com.example.otpsystemspring.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users getUserById( Long id);

    Users getUserByUserName( String username);
}
