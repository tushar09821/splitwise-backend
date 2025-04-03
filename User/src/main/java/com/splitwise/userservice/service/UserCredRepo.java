package com.splitwise.userservice.service;

import com.splitwise.userservice.entity.UserCredentials;
import com.splitwise.userservice.repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;

@Service
public class UserCredRepo {
    @Autowired
    private UserCredentialsRepo userCredentialsRepo;
    public UserCredentials findByUserName(String username) {
        return userCredentialsRepo.findByUsername(username);
    }
}
