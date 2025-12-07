package com.sharique.fitnessfriend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharique.fitnessfriend.dto.RegisterRequest;
import com.sharique.fitnessfriend.dto.UserResponse;
import com.sharique.fitnessfriend.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request){
  return ResponseEntity.ok(userService.register(request));
  }

}
