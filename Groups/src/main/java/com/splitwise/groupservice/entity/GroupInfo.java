package com.splitwise.groupservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GroupInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Date createdOn;

    private List<Integer> usersList;
    private List<Integer> expensesList;

    public GroupInfo() {
    }

    public GroupInfo(int id, String name, Date createdOn, List<Integer> usersList, List<Integer> expensesList) {
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
        this.usersList = usersList;
        this.expensesList = expensesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public List<Integer> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Integer> usersList) {
        this.usersList = usersList;
    }

    public List<Integer> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Integer> expensesList) {
        this.expensesList = expensesList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupInfo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", createdOn=").append(createdOn);
        sb.append(", usersList=").append(usersList);
        sb.append(", expensesList=").append(expensesList);
        sb.append('}');
        return sb.toString();
    }
}
