package com.splitwise.userservice.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserDetailsDTO {
    private String FirstName;
    private String LastName;
    private String email;
    private String contact;
    private int age;
    private Date dateOfBirth;

    private String username;
    private String password;
}
