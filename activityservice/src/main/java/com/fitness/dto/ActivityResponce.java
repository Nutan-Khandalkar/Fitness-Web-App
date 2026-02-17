package com.fitness.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fitness.activityservice.model.ActivityType;

import lombok.Data;

@Data
public class ActivityResponce {
    private String userId;
    private ActivityType type;
    private Integer duration; 
    private Integer caloriesBurned;
    private LocalDateTime startTime; 
    private Map<String, Object> additionalMatrics;
     private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
