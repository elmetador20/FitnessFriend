package com.sharique.activityservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationService{
  
  private final WebClient userServicWebClient;
  
  public Boolean validateUser(String userId){
    log.info("calling user service for {}",userId);
    try{
     return userServicWebClient.get()
     .uri("/api/users/{userId}/validate", userId)
     .retrieve()
     .bodyToMono(Boolean.class)
     .block();

}
catch(WebClientResponseException e){
  e.printStackTrace();

}
  return  false;
}
}
