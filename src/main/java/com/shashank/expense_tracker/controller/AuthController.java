package com.shashank.expense_tracker.controller;


import com.shashank.expense_tracker.dto.LoginRequestDTO;
import com.shashank.expense_tracker.dto.LoginResponseDTO;
import com.shashank.expense_tracker.dto.RegisterRequestDTO;
import com.shashank.expense_tracker.dto.UserResponseDTO;
import com.shashank.expense_tracker.entity.User;
import com.shashank.expense_tracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody RegisterRequestDTO dto){
        User savedUser=service.registerUser(dto);
        UserResponseDTO response=new UserResponseDTO();
        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody @Valid LoginRequestDTO dto){
        String token= service.loginUser(dto);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
