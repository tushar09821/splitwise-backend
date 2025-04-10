package com.splitwise.expenses.repo;

import com.splitwise.expenses.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepo extends JpaRepository<Expenses,Integer> {



    List<Expenses> findByGroupId(Integer groupId);
}
