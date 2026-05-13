package com.shashank.expense_tracker.repository;

import com.shashank.expense_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findByCategoryIgnoreCase(String category);
}
