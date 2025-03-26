package com.splitwise.userservice.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class RegistrationDetailsDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private int age;
    private Date dateOfBirth;

    private String username;
    private String password;
}
