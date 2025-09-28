package com.example.spring.repository;

import com.example.spring.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department , Integer> {

    Optional<Department> findById(Integer department_id);
    boolean existsById(Integer department_id);

    Optional<Department>findByName(String departmentName);
}
