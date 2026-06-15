package com.finess.dto;


import com.finess.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

@NotBlank(message = "Email is required")
@Email(message = "Invalid Email")
private String email;

@NotBlank(message = "Password is required")
    private String password;
    private String firstName;
    private String lastName;
    private UserRole role;
}