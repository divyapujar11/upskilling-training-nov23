package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceImplTest {
	
	@Mock
	StudentRepository studentRepositoryMock;
	
	@InjectMocks
	StudentServiceImpl studentService;
	
	@Test
	public void testGetAllStudents() {
		when(studentRepositoryMock.findAll()).thenReturn(Arrays.asList(new Student(), new Student()));
		List<Student> students = studentService.getAll();
		assertNotNull(students);
		assertEquals(2, students.size());
	}
    
	@Test
	public void testAddStudent() {
		Student studentToAdd = new Student();
		Student addedStudent = studentService.addStudent(studentToAdd);
		assertNotNull(studentToAdd);
	}
	
	@Test
	public void testGetById() {
		int studentId = 1;
		when(studentRepositoryMock.findById(studentId)).thenReturn(Optional.of(new Student()));
		Object result = studentService.getStdById(studentId);
		assertNotNull(result);
	}
	
	@Test
	public void testUpdateById() {
		int studentId = 1;
		Student updatedStudent = new Student();
		updatedStudent.setName("Updated Name");
		updatedStudent.setAge(20);
		updatedStudent.setSalary(40000);
		
		when(studentRepositoryMock.existsById(studentId)).thenReturn(true);
		when(studentRepositoryMock.save(any(Student.class))).thenReturn(updatedStudent);
		
		Object result = studentService.updateStd(updatedStudent, studentId);
		assertNotNull(updatedStudent);
	}
	
	@Test
	public void testDeleteById() {
		int studentId = 1;
		when(studentRepositoryMock.existsById(studentId)).thenReturn(true);
		Object result = studentService.deleteStd(studentId);
		assertNotNull(result);
	}
}
