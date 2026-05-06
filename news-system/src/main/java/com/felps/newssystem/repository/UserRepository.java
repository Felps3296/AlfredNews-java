package com.felps.newssystem.repository;

import com.felps.newssystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByEmail(String email);

}
