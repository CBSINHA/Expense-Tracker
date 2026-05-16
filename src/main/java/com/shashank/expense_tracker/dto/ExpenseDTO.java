package com.shashank.expense_tracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDTO {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @Positive(message = "Amount must be positive")
    private double amount;

    @NotBlank(message = "Category is required")
    private String category;

    private LocalDate date;
}
