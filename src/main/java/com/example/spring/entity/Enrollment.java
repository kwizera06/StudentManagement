package com.example.spring.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;


import java.util.Date;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date enrollmentDate;
    private String status;
    private String grade;
    private Integer score;
    private Integer credits;
    private String pass_status;
    private String repeat_count;
    private Integer semester_number;


}
