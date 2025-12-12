package com.sharique.activityservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
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
private final UserValidationService userValidationService;
private final KafkaTemplate<String , Activity> kafkaTemplate;// use to send data to kafka
@Value("${kafka.topic.name}")
private String topicName;


public ActivityResponse trackActivity(ActivityRequest request){

  Boolean isValidUser=userValidationService.validateUser(request.getUserId());

  if(!isValidUser){
    throw new RuntimeException("invalid user " +request.getUserId());
  }
  Activity activity=Activity.builder()     //object bana rhe h yaha p
                            .userId(request.getUserId())
                            .type(request.getType())
                            .duration(request.getDuration())
                            .caloriesBurned(request.getCaloriesBurned())
                            .startTime(request.getStartTime())    
                            .aditionalMetrics(request.getAditionalMetrics())
                            .build();
  Activity savedActivity=acitvityRepository.save(activity); //db me save kr rhe hai
  try {
    
    kafkaTemplate.send(topicName , savedActivity.getUserId(),savedActivity);
  } catch (Exception e) {
    e.printStackTrace();
  }
  
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
