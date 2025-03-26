package com.splitwise.expenses.model;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expenses {

    @Id
    private Integer ExpenseId;
    private String name;
    private Integer paidByUser;
    private Float amount;

//    @ElementCollection
    private List<Integer> groupMembers;

}
