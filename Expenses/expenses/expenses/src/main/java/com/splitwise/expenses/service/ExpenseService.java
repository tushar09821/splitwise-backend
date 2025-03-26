package com.splitwise.expenses.service;

import com.splitwise.expenses.model.Expenses;
import com.splitwise.expenses.repo.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepo repo;

    public void addExpense(Expenses expense) {
         repo.save(expense);

    }

    public Optional<Expenses> getById(Integer key) {
        return repo.findById(key);
    }
}
