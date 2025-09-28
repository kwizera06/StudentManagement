package com.example.spring.repository;

import com.example.spring.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District , Integer> {
    @Override
    Optional<District> findById(Integer districtId);
}
