package com.example.spring.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer districtId;
    @Column(name="district_name")
    private String name;

    @OneToMany(mappedBy = "district")
    private List<Student> student;


}
