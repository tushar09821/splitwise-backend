package com.splitwise.userservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private int age;
    private Date dateOfBirth;

    private List<Integer> groupsList;

}
