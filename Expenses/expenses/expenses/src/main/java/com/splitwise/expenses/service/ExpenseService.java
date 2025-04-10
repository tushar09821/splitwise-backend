package com.splitwise.expenses.service;

import com.splitwise.expenses.model.Expenses;
import com.splitwise.expenses.repo.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void removeExpense(Integer key) {
        repo.deleteById(key);
    }

    public List<Expenses> allExpenses() {
        return (List<Expenses>) repo.findAll();
    }

    public List<Integer> searchByGroup(Integer groupId) {
              return repo.findByGroupId(groupId)
                .stream()
                .map(Expenses::getExpenseId)
                .collect(Collectors.toList());
    };

}
