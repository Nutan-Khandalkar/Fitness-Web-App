package com.fitness.userservice.services;
import org.springframework.stereotype.Service;
import com.fitness.userservice.Repository.UserRepo;
import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponce;
import com.fitness.userservice.model.Users;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServices {

    private UserRepo userRepository;

public UserResponce register(RegisterRequest registerRequest) {

    if (userRepository.existsByEmail(registerRequest.getEmail())) {
        throw new RuntimeException("Email already exists");   
    }

    Users user = new Users();
    user.setEmail(registerRequest.getEmail());
    user.setPassword(registerRequest.getPassword());
    user.setFirstName(registerRequest.getFirstName());
    user.setLastName(registerRequest.getLastName());

    Users savedUser = userRepository.save(user);

    UserResponce userResponce=new UserResponce();
    userResponce.setId(savedUser.getId());
    userResponce.setEmail(savedUser.getEmail());
    userResponce.setFirstName(savedUser.getFirstName());
    userResponce.setLastName(savedUser.getLastName());
    userResponce.setCreatedAt(savedUser.getCreatedAt());
    userResponce.setUpdatedAt(savedUser.getUpdatedAt());
    userResponce.setPassword(savedUser.getPassword());

    return userResponce;    
}

public UserResponce getMethodName(String userId) {

    Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        UserResponce userResponce=new UserResponce();
        userResponce.setId(user.getId());
        userResponce.setEmail(user.getEmail()); 
        userResponce.setFirstName(user.getFirstName());
        userResponce.setLastName(user.getLastName());
        userResponce.setCreatedAt(user.getCreatedAt());
        userResponce.setUpdatedAt(user.getUpdatedAt());
        userResponce.setPassword(user.getPassword());

    return userResponce;
}

public Boolean existByUserId(String userId) {
    return userRepository.existsById(userId);
}

}
