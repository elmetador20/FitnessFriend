package com.sharique.aiservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sharique.aiservice.model.Recommendation;
import com.sharique.aiservice.repository.RecommendationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {
  private final RecommendationRepository recommendationRepository;

  public List<Recommendation> getUserRecommendation(String userId){
    return recommendationRepository.findByUserId(userId);
  }

  public Recommendation getActivityRecommendation(String activityId){
    return recommendationRepository.findByActivityId(activityId)
    .orElseThrow(()->new RuntimeException("No recommendation found for "+activityId));
  }

}
