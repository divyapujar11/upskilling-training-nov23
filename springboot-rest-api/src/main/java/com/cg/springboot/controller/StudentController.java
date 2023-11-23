package com.cg.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboot.bean.Student;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent() {
		Student student = new Student(1,"Divya","Pujar");
		return student;
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Divya","Pujar"));
		students.add(new Student(2,"Riya","Soya"));
		students.add(new Student(3, "Maya", "Goya"));
		
		return students;
	}
	
	@GetMapping("/students/{id}/{firstname}/{lastname}")
	public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("firstname") String firstName, @PathVariable("lastname") String lastName) {
		return new Student(studentId, firstName, lastName);
	}

}
