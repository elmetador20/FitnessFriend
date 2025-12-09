package com.sharique.activityservice.service;

import org.springframework.stereotype.Service;

import com.sharique.activityservice.dto.ActivityRequest;
import com.sharique.activityservice.dto.ActivityResponse;
import com.sharique.activityservice.model.Activity;
import com.sharique.activityservice.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor //cpnstructor generate krta hai required arguments ka
public class ActivityService {
   
private final ActivityRepository acitvityRepository;//repo ka instance bana rhe haai yaha pe
public ActivityResponse trackActivity(ActivityRequest request){
  Activity activity=Activity.builder()     //object bana rhe h yaha p
                            .userId(request.getUserId())
                            .type(request.getType())
                            .duration(request.getDuration())
                            .caloriesBurned(request.getCaloriesBurned())
                            .startTime(request.getStartTime())    
                            .aditionalMetrics(request.getAditionalMetrics())
                            .build();
  Activity savedActivity=acitvityRepository.save(activity); //db me save kr rhe hai
  return mapToResponse(savedActivity);
}
private ActivityResponse mapToResponse(Activity activity) {
     ActivityResponse response=new ActivityResponse();
     response.setId(activity.getId());
     response.setUserId(activity.getUserId());
     response.setType(activity.getType());    
      response.setDuration(activity.getDuration());
      response.setCaloriesBurned(activity.getCaloriesBurned());
      response.setStartTime(activity.getStartTime());
      response.setAditionalMetrics(activity.getAditionalMetrics());
      response.setCreatedAt(activity.getCreatedAt());
      response.setUpdatedAt(activity.getUpdatedAt());
      return response;

}
  
}
