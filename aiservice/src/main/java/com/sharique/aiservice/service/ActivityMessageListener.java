package com.sharique.aiservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sharique.aiservice.model.Activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {
  
  @KafkaListener(topics="${kafka.topic.name}",groupId="activity-processor-group")
  public void processActivity(Activity activity){
  

    log.info("Recieved activity for processing  {}",activity.getUserId());

  }

}
