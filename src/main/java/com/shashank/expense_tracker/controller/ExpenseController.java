package com.shashank.expense_tracker.controller;


import com.shashank.expense_tracker.entity.Expense;
import com.shashank.expense_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense){
        return service.addExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses(){
        return service.getAllExpenses();
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id){
        boolean deleted=service.deleteExpense(id);
        if(deleted)return "Expense deleted successfully";
        else return "Expense id not found";
    }
}
