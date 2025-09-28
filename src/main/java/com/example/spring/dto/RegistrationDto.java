package com.example.spring.dto;

import com.example.spring.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {


    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private Date dob;
    private String username;
    private String password;
    private Integer department_id;
}