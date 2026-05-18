package com.shashank.expense_tracker.repository;

import com.shashank.expense_tracker.entity.Expense;
import com.shashank.expense_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findByCategoryIgnoreCase(String category);
    List<Expense> findByTitleContainingIgnoreCase(String keyword);
    List<Expense> findByUser(User user);
}
