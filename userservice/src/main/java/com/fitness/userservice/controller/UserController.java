package com.fitness.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponce;
import com.fitness.userservice.services.UserServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    
     private UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<UserResponce> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(userServices.register(registerRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponce> getMethodName(@PathVariable String userId) {
        return ResponseEntity.ok(userServices.getMethodName(userId));
    }
    

     @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> ValidateUser(@PathVariable String userId) {
        return ResponseEntity.ok(userServices.existByUserId(userId));
    }
}
