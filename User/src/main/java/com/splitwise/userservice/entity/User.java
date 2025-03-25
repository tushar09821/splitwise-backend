package com.splitwise.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String FirstName;
    private String LastName;
    private String email;
    private String contact;
    private int age;
    private Date dateOfBirth;

    private List<Integer> groupsList;

    @OneToOne
    @JoinColumn(name = "user_cred_id", unique = true, nullable = false)
    private UserCredentials userCredentials;


}
