package com.splitwise.userservice.repo;

import com.splitwise.userservice.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepo extends JpaRepository<com.splitwise.userservice.entity.UserCredentials, Integer> {

    UserCredentials findByUsername(String username);
}
