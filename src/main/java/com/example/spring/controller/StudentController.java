//package com.example.spring.controller;
//
//import com.example.spring.dto.ApiResponse;
//import com.example.spring.dto.ResponseStudent;
//import com.example.spring.dto.RequestStudentDto;
//import com.example.spring.service.StudentService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@AllArgsConstructor
//@RestController
//@RequestMapping("/auca")
//public class StudentController {
//
//    private final StudentService service;

//    @PostMapping("/std")
//    public ResponseEntity<ApiResponse> request(@RequestBody RequestStudentDto requestStudentDto){
//        try{
//            ApiResponse response =service.createStudent(requestStudentDto);
//            return ResponseEntity.ok(response);
//        } catch (RuntimeException e) {
//            throw new RuntimeException();
//        }
//    }
//    @GetMapping("/std/{id}")
//    public ResponseStudent getStudent(@PathVariable Integer id){
//           return service.getStudent(id);
//    }
//
//    @GetMapping("/std")
//    public List<ResponseStudent> getAllStudent(){
//        return service.getAll();
//    }
//}
