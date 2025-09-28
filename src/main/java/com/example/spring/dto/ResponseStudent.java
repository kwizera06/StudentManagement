package com.example.spring.dto;

import com.example.spring.entity.Role;
import com.example.spring.entity.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStudent {
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private Date dob;
    private Integer userCode;
    private String role;
    private String name;



}


