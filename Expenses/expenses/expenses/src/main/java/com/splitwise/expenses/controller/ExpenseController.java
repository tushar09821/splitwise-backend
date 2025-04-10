package com.splitwise.expenses.controller;

import com.splitwise.expenses.model.Expenses;
import com.splitwise.expenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
@CrossOrigin
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    ExpenseService service;

    @GetMapping("/all")
    public List<Expenses> allExpenses(){
        return service.allExpenses();
    }
    @GetMapping("/{key}")
    public Optional<Expenses> getById(@PathVariable Integer key){
        return service.getById(key);
    }

    @PostMapping("/add")
    public String addExpense(@RequestBody Expenses expense){
        service.addExpense(expense);
        return "Success";
    }
    @DeleteMapping("/{key}")
    public String removeExpense(@PathVariable Integer key){
        Optional<Expenses> expense1=service.getById(key);
        if(expense1.isPresent()) {
            service.removeExpense(key);
            return "Success";
        }
        else{
            return "Expense not available";
        }

    }

    @GetMapping("/group/{groupId}")
    public List<Integer> searchByGroup(@PathVariable Integer groupId){
        return service.searchByGroup(groupId);
    }

}
