package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired StudentRepository studentRepository;
	@Override
	  public List<Student> getAll()  {
		logger.info("All Students");
	      List<Student> list = studentRepository.findAll();
	      return list;
	  }
	
	@Override
	  public Student addStudent(Student student) {
		logger.info("Add Students");
	      return studentRepository.save(student);

	  }
	@Override
	  public Object getStdById(int id) {
		logger.info("Get Student by ID");
	      return studentRepository.findById(id);
	  }
	@Override
	public Object updateStd(Student updatedStudent, int id) {
		logger.info("Update Students");
		boolean ustudent = studentRepository.existsById(id);
		if(ustudent) {
			Student student = new Student();
			student.setName(updatedStudent.getName());
			student.setAge(updatedStudent.getAge());
			student.setId(id);
			student.setSalary(updatedStudent.getSalary());
		
		      return studentRepository.save(student);
		
	} else {
		logger.error("Null");
		return null;
} 
		
	}
	

	@Override
	public Object deleteStd(int id) {
		if (studentRepository.existsById(id)) {
	    	studentRepository.deleteById(id);
	      return "Employee: " + id + " Deleted";
	    
	  }
		return null;
	}
}

	