package com.sharique.fitnessfriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sharique.fitnessfriend.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
