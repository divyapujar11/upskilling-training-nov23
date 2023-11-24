package com.cg.studentcrud.Studentdetailscrud.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "studentsdetails")
public class Student {
    @Id
    private Long id;
    private String name;
    private int age;
    private double salary;
}

