package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestStudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private Date dob;
    private String address;
   private Integer districtId;
   private Integer department_id;


}
