package com.shashank.expense_tracker.controller;


import com.shashank.expense_tracker.dto.ExpenseDTO;
import com.shashank.expense_tracker.entity.Expense;
import com.shashank.expense_tracker.entity.User;
import com.shashank.expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @PostMapping
    public ResponseEntity<ExpenseDTO> addExpense(@Valid @RequestBody ExpenseDTO dto){
        Expense expense = convertToEntity(dto);
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        User user=(User)authentication.getPrincipal();
        expense.setUser(user);
        Expense addedExpense= service.addExpense(expense);
        ExpenseDTO responseDto=convertToDTO(addedExpense);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        User user=(User)authentication.getPrincipal();
        return ResponseEntity.ok(service.getUserExpenses(user).stream().map(this::convertToDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable Long id){
        return ResponseEntity.ok(convertToDTO(service.getExpensebyId(id)));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ExpenseDTO>> getExpensesByCategory(
            @PathVariable String category) {

        return ResponseEntity.ok(
                service.getExpensesByCategory(category).stream().map(this::convertToDTO).toList()
        );
    }

    @GetMapping("/sorted/{field}")
    public ResponseEntity<List<ExpenseDTO>> getSortedExpenses(@PathVariable String field){
        return ResponseEntity.ok(service.getSortedExpenses(field).stream().map(this::convertToDTO).toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id){
        boolean deleted=service.deleteExpense(id);
        if(deleted)return ResponseEntity.ok("Expense deleted successfully");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense id not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Long id,@Valid @RequestBody ExpenseDTO dto){
        Expense expense=convertToEntity(dto);
        return ResponseEntity.ok(convertToDTO(service.updateExpense(id,expense)));
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<ExpenseDTO>> getPaginatedResponse(@RequestParam int page, @RequestParam int size){
        Page<ExpenseDTO> dtoPage=service.getPaginatedExpense(page, size).map(this::convertToDTO);
        return ResponseEntity.ok(dtoPage);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ExpenseDTO>> searchExpenses(@RequestParam String keyword){
        return ResponseEntity.ok(service.findByTitle(keyword).stream().map(this::convertToDTO).toList());
    }




    private Expense convertToEntity(ExpenseDTO dto) {

        Expense expense = new Expense();

        expense.setId(dto.getId());
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setDate(dto.getDate());

        return expense;
    }


    private ExpenseDTO convertToDTO(Expense expense) {

        ExpenseDTO dto = new ExpenseDTO();

        dto.setId(expense.getId());
        dto.setTitle(expense.getTitle());
        dto.setAmount(expense.getAmount());
        dto.setCategory(expense.getCategory());
        dto.setDate(expense.getDate());

        return dto;
    }
}
