package com.splitwise.userservice.repo;

import com.splitwise.userservice.entity.User;
import com.splitwise.userservice.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


}
