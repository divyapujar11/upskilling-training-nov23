package com.cg.studentcrud.Studentdetailscrud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.studentcrud.Studentdetailscrud.model.Student;
import com.cg.studentcrud.Studentdetailscrud.repository.StudentRepository;

@Service
public class StudentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        LOGGER.info("Fetching all students");
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        LOGGER.info("Fetching student by ID: {}", id);
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        LOGGER.info("Saving student: {}", student);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        LOGGER.info("Deleting student by ID: {}", id);
        studentRepository.deleteById(id);
    }
}
