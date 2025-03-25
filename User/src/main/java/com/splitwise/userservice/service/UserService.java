package com.splitwise.userservice.service;

import com.splitwise.userservice.entity.User;
import com.splitwise.userservice.pojo.UserDetailsDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface UserService {

    User findByID(int id);

    User createUser(UserDetailsDTO userDetailDTO);
}
