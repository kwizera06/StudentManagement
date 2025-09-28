package com.example.spring.controller;

import com.example.spring.dto.ApiResponse;
import com.example.spring.dto.OtpVerificationDto;
import com.example.spring.dto.RegistrationDto;

import com.example.spring.dto.ResponseStudent;
import com.example.spring.service.RegistrationService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/auca")
public class RegistrationController {
    private final RegistrationService serv;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> reg(@RequestBody RegistrationDto registration) {
        try {
            ApiResponse response = serv.register(registration);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ApiResponse(e.getMessage()));
        }


    }
    @GetMapping("/std")
    public List<ResponseStudent> getAllStudent(){
        return serv.getAll();
    }
    @PostMapping("/otp")
    public ResponseEntity<ApiResponse> otpVerify(@RequestBody OtpVerificationDto otpVerificationDto){
        try{
            ApiResponse response =serv.otpverify(otpVerificationDto);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ApiResponse(e.getMessage()));
        }
    }
}
