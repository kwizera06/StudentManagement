package com.example.spring.service;

import com.example.spring.dto.ApiResponse;
import com.example.spring.entity.District;
import com.example.spring.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DistrictService {
    private final DistrictRepository districtRepository;


    public ApiResponse createDistrict(District district){
        districtRepository.save(district);
        return  new ApiResponse("District Saved Successfully");
    }
}
