package com.splitwise.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepo extends JpaRepository<com.splitwise.userservice.entity.UserCredentials, Integer> {
}
