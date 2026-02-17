package com.fitness.activityservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fitness.activityservice.services.ActivityServices;
import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityServices activityServices;
    
    @PostMapping
    public ResponseEntity<ActivityResponce> treckActivity(@RequestBody ActivityRequest request) {

        
        return ResponseEntity.ok(activityServices.trackActivity(request));
    }

    
}
