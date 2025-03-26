package com.splitwise.expenses.repo;

import com.splitwise.expenses.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends JpaRepository<Expenses,Integer> {
}
