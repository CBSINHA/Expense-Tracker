package com.shashank.expense_tracker.controller;


import com.shashank.expense_tracker.entity.Expense;
import com.shashank.expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @PostMapping
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense){
        Expense addedExpense= service.addExpense(expense);
        return new ResponseEntity<>(addedExpense, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok(service.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
        return ResponseEntity.ok(service.getExpensebyId(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expense>> getExpensesByCategory(
            @PathVariable String category) {

        return ResponseEntity.ok(
                service.getExpensesByCategory(category)
        );
    }

    @GetMapping("/sorted/{field}")
    public ResponseEntity<List<Expense>> getSortedExpenses(@PathVariable String field){
        return ResponseEntity.ok(service.getSortedExpenses(field));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        boolean deleted=service.deleteExpense(id);
        if(deleted)return ResponseEntity.ok("Expense deleted successfully");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense id not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense){
        return ResponseEntity.ok(service.updateExpense(id,expense));
    }
}
