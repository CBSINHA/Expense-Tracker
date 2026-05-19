package com.shashank.expense_tracker.repository;

import com.shashank.expense_tracker.entity.Expense;
import com.shashank.expense_tracker.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository
        extends JpaRepository<Expense, Long> {

    List<Expense>
    findByCategoryIgnoreCaseAndUser(
            String category,
            User user
    );

    List<Expense>
    findByTitleContainingIgnoreCaseAndUser(
            String keyword,
            User user
    );

    List<Expense>
    findByUser(User user);

    Page<Expense>
    findByUser(
            User user,
            Pageable pageable
    );

    List<Expense>
    findByUser(
            User user,
            org.springframework.data.domain.Sort sort
    );
}