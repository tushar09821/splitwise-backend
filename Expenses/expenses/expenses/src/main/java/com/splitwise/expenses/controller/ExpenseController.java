package com.splitwise.expenses.controller;

import com.splitwise.expenses.model.Expenses;
import com.splitwise.expenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@CrossOrigin
public class ExpenseController {

    @Autowired
    ExpenseService service;

    @GetMapping("/{key}")
    public Optional<Expenses> getById(@PathVariable Integer key){
        return service.getById(key);
    }

    @PostMapping("/expense")
    public String addExpense(@RequestBody Expenses expense){
        service.addExpense(expense);
        return "Success";
    }

}
