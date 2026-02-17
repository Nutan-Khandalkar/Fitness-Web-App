package com.fitness.userservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.userservice.model.Users;

public interface UserRepo extends JpaRepository<Users, String> {

    Boolean existsByEmail(String email);

    
}