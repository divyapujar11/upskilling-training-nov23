package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void testStudentData() {
		Student data = new Student();
		data.setId(4);
		data.setName("Abc");
		data.setAge(30);
		data.setSalary(50000L);
		
		data.getId();
		data.getName();
		data.getAge();
		data.getSalary();
		
		assertNotNull(data);
	}
	
	@Test
	public void testStudentConstructor() {
		int id = 4;
		String name = "Abc";
		int age = 30;
		double salary = 30000;
		
	Student student = new Student(name, age, salary);
	assertNotNull(student);
	
	}

}
