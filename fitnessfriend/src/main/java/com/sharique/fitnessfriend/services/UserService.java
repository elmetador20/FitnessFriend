package com.sharique.fitnessfriend.services;

import javax.management.RuntimeErrorException;

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

    if(repository.existsByEmail(request.getEmail())){
      throw new RuntimeException("Email already exist");



    }
    User user=new User();
    user.setEmail(request.getEmail());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setPassword(request.getPassword());
     User savedUser=repository.save(user);
     UserResponse userResponse =new UserResponse();// userresposne ka object banaya hai yaha pe
     userResponse.setId(savedUser.getId());
     userResponse.setPassword(savedUser.getPassword());
     userResponse.setEmail(savedUser.getEmail());
     userResponse.setFirstName(savedUser.getFirstName());   
      userResponse.setLastName(savedUser.getLastName());  
      userResponse.setCreatedAt(savedUser.getCreatedAt());
      userResponse.setUpdatedAt(savedUser.getUpdatedAt());
     return userResponse;


  }
  public UserResponse  getUserProfile(String userId) {
   User user=repository.findById(userId)
    .orElseThrow(()->new RuntimeException("User not found"));
    UserResponse userResponse =new UserResponse();// userresposne ka object banaya hai yaha pe
     userResponse.setId(user.getId());
     userResponse.setPassword(user.getPassword());
     userResponse.setEmail(user.getEmail());
     userResponse.setFirstName(user.getFirstName());   
      userResponse.setLastName(user.getLastName());  
      userResponse.setCreatedAt(user.getCreatedAt());
      userResponse.setUpdatedAt(user.getUpdatedAt());
     return userResponse;
  }

}
