package com.shashank.expense_tracker.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

@NotBlank(message = "Username or Email required")
private String login;

@NotBlank(message = "Password required")
private String password;
}
