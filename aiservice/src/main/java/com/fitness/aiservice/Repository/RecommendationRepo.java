package com.fitness.aiservice.Repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fitness.aiservice.model.Recommendation;

@Repository
public interface RecommendationRepo extends MongoRepository<Recommendation, String> {
    List<Recommendation> findByUserId(String userId);
    List<Recommendation> findByActivityId(String activityId);
}
