package com.fitness.userservice.dto;
import java.time.LocalDateTime;
import jakarta.persistence.Column;

import lombok.Data;

@Data
public class UserResponce {

    private String id;

    private String email;
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
