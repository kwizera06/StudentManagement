//package com.example.spring.service;
//
//import com.example.spring.dto.ApiResponse;
//import com.example.spring.dto.DepartmentDto;
//import com.example.spring.dto.ResponseStudent;
//import com.example.spring.dto.RequestStudentDto;
//import com.example.spring.entity.Department;
//import com.example.spring.entity.District;
//import com.example.spring.entity.Student;
//import com.example.spring.entity.UserAccount;
//import com.example.spring.repository.DepartmentRepository;
//import com.example.spring.repository.DistrictRepository;
//import com.example.spring.repository.StudentRepository;
//import com.example.spring.repository.UserAccountRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@AllArgsConstructor
//@Service
//public class StudentService {
//
//    private final UserAccountRepository userAccountRepository;
//    private final DistrictRepository districtRepository;
//    private final StudentRepository repo;
//    private final DepartmentRepository rep;


//    public ApiResponse createStudent(RequestStudentDto std){
//        UserAccount userAccount =userAccountRepository.findById(std.getUserId())
//               .orElseThrow(()-> new RuntimeException("UserAccount Id "+std.getUserId()+ " is invalid"));
//        UserAccount userAccount = userAccountRepository.findById(std.getId()).orElseThrow(()->new RuntimeException("the UserAccount Iis not created"));
//        District district = districtRepository.findById(std.getDistrictId())
//                .orElseThrow(()-> new RuntimeException("District id " +std.getDistrictId()+" is invalid"));
//
//        Department department = rep.findById(std.getDepartment_id())
//                .orElseThrow(()-> new RuntimeException("Department Id " +std.getDepartment_id() +" is invalid"));
//
//        Student student = Student.builder()
//                .id(std.getId())
//                .firstName(std.getFirstName())
//                .lastName(std.getLastName())
//                .email(std.getEmail())
//                .phone(std.getPhone())
//                .dob(std.getDob())
//                .userAccount(userAccount)
//                .department(department)
//                .district(district)
//                .build();
//
//        std.setId(2000+ std.getId());
//        repo.save(student);
//     return new ApiResponse("Student saved Successfully");
//    }

//    public ResponseStudent getStudent(Integer id){
//        Student student = repo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student with id " + id + " not found"));
//UserAccount userAccount =student.getUserAccount();
//Department department = student.getDepartment();
//        // Convert Entity -> DTO
//        return new ResponseStudent(
//                student.getFirstName(),
//                student.getLastName(),
//                student.getEmail(),
//                student.getPhone(),
//                userAccount.getUserCode(),
//                department.getName()
//
//        );


//                .departmentDto(DepartmentDto.builder()
//                        .department_id(student.getDepartment().getDepartment_id())
//                        .name(student.getDepartment().getName())
//                        .build())

//    }
//
//    public List<ResponseStudent> getAll(){
//        List<Student> students =repo.findAll();
//        return students.stream().map(std->{
//            UserAccount userAccount = std.getUserAccount();
//            Department department = std.getDepartment();
//            return new ResponseStudent(
//                    std.getFirstName(),
//                    std.getLastName(),
//                    std.getEmail(),
//                    std.getPhone(),
//                    userAccount.getUserCode(),
//                    department.getName()
//            );
//        }).toList();
//    }
//public List<ResponseStudent> getAll() {
//    List<Student> students = repo.findAll();
//    return students.stream().map(std -> {
//        UserAccount userAccount = std.getUserAccount();
//        DepartmentDto departmentDto = null;
//        if (std.getDepartment() != null) {
//            departmentDto = new DepartmentDto(std.getDepartment().getId(), std.getDepartment().getName());
//        }
//
//        return new ResponseStudent(
//                std.getId(),
//                std.getFirstName(),
//                std.getLastName(),
//                std.getEmail(),
//                std.getPhone(),     // make sure type matches
//               departmentDto,
//                userAccount != null ? userAccount.getUserCode() : null
//        );
//    }).toList();
//}


//}
