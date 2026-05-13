package com.shashank.expense_tracker.service;

import com.shashank.expense_tracker.entity.Expense;
import com.shashank.expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
@Autowired
    private ExpenseRepository repository;

public Expense addExpense(Expense expense){
    return repository.save(expense);
}

public List<Expense> getAllExpenses(){
    return repository.findAll();
}

public boolean deleteExpense(Long id){
    if(repository.existsById(id)){repository.deleteById(id);return true;}
    return false;
}
}
