package com.shashank.expense_tracker.service;

import com.shashank.expense_tracker.entity.Expense;
import com.shashank.expense_tracker.entity.User;
import com.shashank.expense_tracker.repository.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;


    public Expense addExpense(
            Expense expense
    ) {

        return repository.save(expense);
    }


    public List<Expense>
    getUserExpenses(User user) {

        return repository.findByUser(user);
    }


    public Expense getExpensebyId(
            Long id
    ) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Expense not found"
                        )
                );
    }


    public List<Expense>
    getExpensesByCategory(
            String category,
            User user
    ) {

        return repository
                .findByCategoryIgnoreCaseAndUser(
                        category,
                        user
                );
    }


    public List<Expense>
    getSortedExpenses(
            String field,
            User user
    ) {

        return repository.findByUser(
                user,
                Sort.by(
                        Sort.Direction.DESC,
                        field
                )
        );
    }


    public boolean deleteExpense(
            Long id
    ) {

        if (
                repository.existsById(id)
        ) {

            repository.deleteById(id);

            return true;
        }

        return false;
    }


    public Expense updateExpense(
            long id,
            Expense expense
    ) {

        Expense oldExpense =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Expense not found"
                                )
                        );

        oldExpense.setAmount(
                expense.getAmount()
        );

        oldExpense.setDate(
                expense.getDate()
        );

        oldExpense.setCategory(
                expense.getCategory()
        );

        oldExpense.setTitle(
                expense.getTitle()
        );

        return repository.save(
                oldExpense
        );
    }


    public Page<Expense>
    getPaginatedExpense(
            int page,
            int length,
            User user
    ) {

        Pageable pageable =
                PageRequest.of(
                        page,
                        length
                );

        return repository.findByUser(
                user,
                pageable
        );
    }


    public List<Expense>
    findByTitle(
            String keyword,
            User user
    ) {

        return repository
                .findByTitleContainingIgnoreCaseAndUser(
                        keyword,
                        user
                );
    }
}