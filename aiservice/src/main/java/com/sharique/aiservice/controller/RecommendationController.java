package com.sharique.aiservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharique.aiservice.model.Recommendation;
import com.sharique.aiservice.service.RecommendationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //use to autoinject the object without making constructor
@RequestMapping("/api/recommendations")
public class RecommendationController {
   private final RecommendationService recommendationService;


  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Recommendation>>  getUserRecommendation(@PathVariable String userId){
    return ResponseEntity.ok(recommendationService.getUserRecommendation(userId));
     
  }
 @GetMapping("/activity/{activityId}")
  public ResponseEntity<Recommendation>  getActivityRecommendation(@PathVariable String activityId){
     return ResponseEntity.ok(recommendationService.getActivityRecommendation(activityId));

  }
}
