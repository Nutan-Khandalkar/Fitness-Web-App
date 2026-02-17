package com.fitness.activityservice.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.Repository.ActivityRepo;
import com.fitness.activityservice.model.Activity;
import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponce;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityServices {

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private final UserValidationService userValidationService;


    public ActivityResponce trackActivity(ActivityRequest request) {
        
        boolean isValid = userValidationService.validateUser(request.getUserId());
        if(!isValid){
            throw new RuntimeException("Invalid user ID: " + request.getUserId());
        }

        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMatrics(request.getAdditionalMatrics())
                .build();

        Activity savedActivity = activityRepo.save(activity);

        ActivityResponce responce = new ActivityResponce();
        responce.setUserId(savedActivity.getUserId());
        responce.setType(savedActivity.getType());
        responce.setDuration(savedActivity.getDuration());
        responce.setCaloriesBurned(savedActivity.getCaloriesBurned());
        responce.setStartTime(savedActivity.getStartTime());
        responce.setAdditionalMatrics(savedActivity.getAdditionalMatrics());
        responce.setCreatedAt(savedActivity.getCreatedAt());
        responce.setUpdatedAt(savedActivity.getUpdatedAt());


        return responce;
    }

    public List<Activity> getAllActivities() {
        return activityRepo.findAll();
    }



    
}
