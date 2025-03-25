package com.splitwise.userservice.service;

import com.splitwise.userservice.entity.User;
import com.splitwise.userservice.entity.UserCredentials;
import com.splitwise.userservice.pojo.UserDetailsDTO;
import com.splitwise.userservice.repo.UserCredentialsRepo;
import com.splitwise.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserCredentialsRepo userCredentialsRepo;

    @Override
    public User findByID(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User createUser(UserDetailsDTO userDetailDTO) {

        User user = new User();
        user.setAge(userDetailDTO.getAge());
        user.setEmail(userDetailDTO.getEmail());
        user.setContact(userDetailDTO.getContact());
        user.setFirstName(userDetailDTO.getFirstName());
        user.setLastName(userDetailDTO.getLastName());
        user.setDateOfBirth(userDetailDTO.getDateOfBirth());

        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUsername(userDetailDTO.getUsername());
        userCredentials.setPassword(userDetailDTO.getPassword());
        userCredentialsRepo.save(userCredentials);

        user.setUserCredentials(userCredentials);
        userRepo.save(user);


        return user;
    }
}
