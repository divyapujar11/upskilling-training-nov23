package com.example.demo;

import java.util.List;

public interface StudentService {
	
	public List<Student> getAll();


	public Object addStudent(Student st);

	public Object getStdById(int id);


	public Object updateStd(Student student, int id);


	public Object deleteStd(int id);
}
