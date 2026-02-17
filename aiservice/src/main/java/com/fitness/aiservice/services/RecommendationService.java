package com.fitness.aiservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitness.aiservice.Repository.RecommendationRepo;
import com.fitness.aiservice.model.Recommendation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepo recommendationRepo;

    public List<Recommendation> getRecommendationsForUser(String userId) {
    
        return recommendationRepo.findByUserId(userId);
    }

    public List<Recommendation> getRecommendationsForActivity(String activityId) {
        return recommendationRepo.findByActivityId(activityId);
    }
    
}
