package com.splitwise.userservice.util;

import com.splitwise.userservice.entity.UserCredentials;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CredentialUserDetails implements UserDetails{

    private UserCredentials userCredentials;

    public CredentialUserDetails(UserCredentials userCredentials){
        this.userCredentials=userCredentials;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return userCredentials.getPassword();
    }

    @Override
    public String getUsername() {
        return userCredentials.getUsername();
    }
}
