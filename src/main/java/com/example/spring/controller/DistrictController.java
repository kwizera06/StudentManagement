package com.example.spring.controller;

import com.example.spring.dto.ApiResponse;
import com.example.spring.entity.District;
import com.example.spring.service.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auca")
public class DistrictController {

    private final DistrictService service;

    @PostMapping("district")
    public ResponseEntity<ApiResponse> dist(@RequestBody District district){
        ApiResponse response=service.createDistrict(district);
        return ResponseEntity.ok(response);
    }
}
