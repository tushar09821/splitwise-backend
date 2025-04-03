package com.splitwise.userservice.service;

import com.splitwise.userservice.entity.UserCredentials;
import com.splitwise.userservice.util.CredentialUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    public UserCredRepo userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials  user = userService.findByUserName(username);

        if(user==null){
            throw new UsernameNotFoundException("User does not exists");
        }
        return new CredentialUserDetails(user);
    }
}
