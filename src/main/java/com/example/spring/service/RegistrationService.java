package com.example.spring.service;

import com.example.spring.dto.*;
import com.example.spring.entity.Department;
import com.example.spring.entity.Role;
import com.example.spring.entity.Student;
import com.example.spring.entity.UserAccount;
import com.example.spring.repository.DepartmentRepository;
import com.example.spring.repository.StudentRepository;
import com.example.spring.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class RegistrationService {
    public UserAccountRepository rep;
    public StudentRepository repo;
    public EmailService mail;
    private final DepartmentRepository departmentRepo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //Registering Student

    public ApiResponse register(RegistrationDto registration) {
        if (repo.existsByEmail(registration.getEmail())) {
            throw new RuntimeException("Email already exists , please use other");
        }
        if(!registration.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            throw new RuntimeException("the Email is incorrect please check how it is written and rewrite it");
        }

        String otp = String.valueOf(new Random().nextInt(999999));
        if(otp.length()<6){
            otp = String.format("%06d",Integer.parseInt(otp));
        }
        Department department = departmentRepo.findById(registration.getDepartment_id())
                .orElseThrow(() -> new RuntimeException("Department   not found"));
            UserAccount userAccount = UserAccount.builder()
                    .username(registration.getUsername())
                    .userCode(0)
                    .role(Role.STUDENT)
                    .password(passwordEncoder.encode(registration.getPassword()))
                    .build();
         rep.save(userAccount);
                 userAccount.setUserCode(20000+ userAccount.getId());
        rep.save(userAccount);
            Student student = Student.builder()
                    .firstName(registration.getFirstName())
                    .lastName(registration.getLastName())
                    .email(registration.getEmail())
                    .phone(registration.getPhone())
                    .dob(registration.getDob())
                    .otp(otp)
                    .otpExpired(LocalDateTime.now().plusMinutes(10))
                    .userAccount(userAccount)
                    .department(department)
                    .build();

            repo.save(student);
            mail.sendOtp(registration.getEmail(), otp);
            return new ApiResponse("Registered Successfully");
        }

        //Retrive All students in the database

    public List<ResponseStudent> getAll(){
        List<Student> students =repo.findAll();
        return students.stream().map(std -> {
            UserAccount userAccount = std.getUserAccount();
            Department department = std.getDepartment();
            return new ResponseStudent(
                    std.getFirstName(),
                    std.getLastName(),
                    std.getEmail(),
                    std.getPhone(),
                    std.getDob(),
                    userAccount != null ? userAccount.getUserCode() : null,
                    userAccount != null ? userAccount.getRole().name() : null,
                    department != null ? department.getName() : null
            );
        }).toList();

    }



    //Otp Verification
public ApiResponse otpverify(OtpVerificationDto otpVerificationDto){
        Student student =repo.findByEmail(otpVerificationDto.getEmail()).orElseThrow(()-> new RuntimeException("Email is Invalid"));
        if(student.isVerfied()){
            return new ApiResponse("Account is Already Verified");
        }
        if(student.getOtpExpired().isBefore(LocalDateTime.now())){
            return new ApiResponse("OTP is Expired please ask for the other one");
        }
        if(!student.getOtp().equals(otpVerificationDto.getOtp())){
            return new ApiResponse("OTP is Incorrect");
        }
        student.setVerfied(true);
        student.setOtpExpired(null);
        student.setOtp(null);
        repo.save(student);

        return new ApiResponse("Account verified Successfully you can Login");
}

    }
