package com.example.spring.repository;

import com.example.spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer> {

    Optional<Student> findByEmail(String email);
    boolean existsByEmail(String email);


}
