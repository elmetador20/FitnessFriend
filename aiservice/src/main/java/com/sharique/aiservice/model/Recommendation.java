package com.sharique.aiservice.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "recommendations")
@Data
@Builder //used to create the obejct

public class Recommendation {
  @Id
  private String id;
  private String activityId;
  private String userId;
  private String recommendation;

  private List<String> suggestions;
  private List<String> safety;
  private List<String> improvements;


  @CreatedDate
  private LocalDateTime createdAt;

}
