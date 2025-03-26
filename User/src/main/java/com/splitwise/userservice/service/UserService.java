package com.splitwise.userservice.service;

import com.splitwise.userservice.entity.User;
import com.splitwise.userservice.pojo.RegistrationDetailsDTO;


public interface UserService {

    User findByID(int id);

    User createUser(RegistrationDetailsDTO userDetailDTO);
}
