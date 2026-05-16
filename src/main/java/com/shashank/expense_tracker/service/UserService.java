package com.shashank.expense_tracker.service;

import com.shashank.expense_tracker.dto.RegisterRequestDTO;
import com.shashank.expense_tracker.entity.User;
import com.shashank.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(RegisterRequestDTO dto){
        if(repository.existsByEmail(dto.getEmail()))throw new RuntimeException("Email already exists!");
        if(repository.existsByUsername(dto.getUsername()))throw new RuntimeException("Username already exists!");
        User user=new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return repository.save(user);
    }
}
