package com.sharique.fitnessfriend.services;

import org.springframework.stereotype.Service;

import com.sharique.fitnessfriend.dto.RegisterRequest;
import com.sharique.fitnessfriend.dto.UserResponse;
import com.sharique.fitnessfriend.models.User;
import com.sharique.fitnessfriend.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {


  private final  UserRepository repository;
  public UserResponse register(RegisterRequest request) {
    User user=new User();
    user.setEmail(request.getEmail());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setPassword(user.getPassword());
     User savedUser=new User();
     UserResponse response =new UserResponse();
  }

}
