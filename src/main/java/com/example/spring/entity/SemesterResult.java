package com.example.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SemesterResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String academic_year;
    private Integer average_score;
    private Integer average_major;
    private Integer average_minor;
    private Integer average_general;
    private Integer credits_earned;
    private Integer major_credits_earned;
    private Integer minor_credits_earned;
    private Integer general_credits_earned;
    private String status;
}
