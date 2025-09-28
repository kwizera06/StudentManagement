package com.example.spring.service;

import com.example.spring.dto.ApiResponse;
import com.example.spring.entity.Department;
import com.example.spring.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
@PostMapping("/dpt")
    public ApiResponse createDepartment(Department department){
        departmentRepository.save(department);
        return new ApiResponse("Department Saved Successfully");
    }
}
