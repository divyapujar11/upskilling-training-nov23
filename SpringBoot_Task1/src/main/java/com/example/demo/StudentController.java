package com.example.demo;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api")
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired StudentService studentService;
	
	@GetMapping(path = "/all")
	  public ResponseEntity<List<Student>> getAll(){
		logger.info("All Students");
	    List<Student> list = studentService.getAll();
	    return ResponseEntity.ok(list);
	  }
	
	 @PostMapping(path = "/add")
		  public ResponseEntity<Object> addEmp(@RequestBody Student st) {
		    try {
		    logger.info("Add Students");
		      return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(st));

		    } catch (Exception e) {
		    	logger.error("Not created");
		      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		    }
		  }
	 
	 @GetMapping(path = "/getStd/{id}")
	  public ResponseEntity<Object> getEmpById(@PathVariable("id") int id) {
	    try {
	    logger.info("Get Student by ID");
	      return ResponseEntity.status(HttpStatus.OK).body(studentService.getStdById(id));
	    } catch (Exception e) {
	    	logger.error("No ID");
	      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	 }
	 
	@PutMapping(path = "/update/{id}")
		  public ResponseEntity<Object> updateStd(@RequestBody Student student, @PathVariable int id) {
			logger.info("Update Students");
		      return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStd(student, id));
		  }
	@DeleteMapping(path = "/delete/{id}")
	  public ResponseEntity<Object> deleteStd(@PathVariable("id") int id) {
		logger.info("Delete Students");
	      return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStd(id));
	  }
}

