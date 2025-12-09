package com.sharique.activityservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharique.activityservice.dto.ActivityRequest;
import com.sharique.activityservice.dto.ActivityResponse;
import com.sharique.activityservice.service.ActivityService;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
  private ActivityService activityService;

  @PostMapping
  public ResponseEntity<ActivityResponse> trackActiviy(@RequestBody ActivityRequest request){

  return ResponseEntity.ok(activityService.trackActivity(request));

}}
