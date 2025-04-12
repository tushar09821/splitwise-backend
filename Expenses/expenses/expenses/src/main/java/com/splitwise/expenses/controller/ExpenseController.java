package com.splitwise.expenses.controller;

import com.splitwise.expenses.model.Expenses;
import com.splitwise.expenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Expenses>> allExpenses(){

        List<Expenses>expense1=service.allExpenses();
        if(expense1!=null)
            return new ResponseEntity<>(expense1, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{key}")
    public ResponseEntity<Optional<Expenses>> getById(@PathVariable Integer key){

        Optional<Expenses> result= service.getById(key);
        if(result.isPresent())
            return new ResponseEntity<>(result, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addExpense(@RequestBody Expenses expense){
        service.addExpense(expense);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{key}")
    public ResponseEntity<String> removeExpense(@PathVariable Integer key){
        Optional<Expenses> expense1=service.getById(key);
        if(expense1.isPresent()) {
            service.removeExpense(key);
            return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>("Expense not available",HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<Integer>> searchByGroup(@PathVariable Integer groupId){
        List<Integer> result=service.searchByGroup(groupId);
        if(result!=null)
            return new ResponseEntity<>(result,HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
