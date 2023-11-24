package com.cg.studentcrud.Studentdetailscrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.studentcrud.Studentdetailscrud.model.Student;
import com.cg.studentcrud.Studentdetailscrud.service.StudentService;

@SpringBootTest
class StudentDetailsCrudApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
    private StudentService studentService;

    @Test
    public void testSaveAndGetStudent() {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(25);
        student.setSalary(50000.0);

        Student savedStudent = studentService.saveStudent(student);
        assertNotNull(savedStudent.getId());

        Student fetchedStudent = studentService.getStudentById(savedStudent.getId());
        assertNotNull(fetchedStudent);
        assertEquals("John Doe", fetchedStudent.getName());
        assertEquals(25, fetchedStudent.getAge());
        assertEquals(50000.0, fetchedStudent.getSalary());
    }
}
