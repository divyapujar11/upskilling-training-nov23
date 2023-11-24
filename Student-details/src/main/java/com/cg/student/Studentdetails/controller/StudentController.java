package com.cg.student.Studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.student.Studentdetails.model.Student;
import com.cg.student.Studentdetails.repository.StudentRepository;

@RestController	
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping("/find")
	public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

	@PostMapping("/add")
    public Student saveStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

}
