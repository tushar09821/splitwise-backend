package com.splitwise.expenses.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId;
    private String name;
    private Integer paidByUser;
    private Float amount;
    private Integer createdByUser;
    private Integer groupId;
    private Date createDate;
//    @ElementCollection
    private List<Integer> ExpenseMembers;

    @PrePersist
    private void PrePersist(){
        this.createDate=new Date();
    }

}
