package com.example.spring.controller;

import com.example.spring.dto.ApiResponse;
import com.example.spring.entity.Department;
import com.example.spring.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/auca")
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping("/dpt")
    public ResponseEntity<ApiResponse> createDepart(@RequestBody Department department){
        ApiResponse response = service.createDepartment(department);
        return ResponseEntity.ok(response);
    }
}
