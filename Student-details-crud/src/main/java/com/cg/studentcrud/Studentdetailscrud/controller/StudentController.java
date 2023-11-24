package com.cg.studentcrud.Studentdetailscrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.studentcrud.Studentdetailscrud.model.Student;
import com.cg.studentcrud.Studentdetailscrud.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getStudents")
	public List<Student> getStudentDetails() {
		return this.studentService.getAllStudents();
	}
	
	@PostMapping("/addDetails")
	public Student addStudentDetails(@RequestBody Student student) {
		return this.studentService.saveStudent(student);
	}
	
	@PutMapping("/updateDetails")
	public Student updateStudentDetails(@RequestBody Student student) {
		return this.studentService.saveStudent(student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String id){
		try {
			this.studentService.deleteStudent(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
}
