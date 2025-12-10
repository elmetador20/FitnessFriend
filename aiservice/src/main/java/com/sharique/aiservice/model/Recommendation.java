package com.sharique.aiservice.model;

import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Builder;
import lombok.Data;

@Document(collection="recommendations")
@Data
@Builder//builder is used to create the objects
public class Recommendation {
  @Id
   private String id;
   @NonNull
   private String activityId;
   private String userId;
   private String recommendation;
   private List<String> suggestions;
   private List<String> safety;
   private List<String> improvements;

  @CreatedDate
  private LocalDateTime createdAt;


}
