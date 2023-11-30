package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc

public class StudentControllerTest {
	
	@Mock
	StudentService studentService;
	
	@Mock
	StudentRepository studentRepository;
	
	@Mock
	MockMvc mockMvc;
	
	@InjectMocks
	public StudentController studentController;
	
	@BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }
	
	@Test
	public void testGetAllStudents() throws Exception {
		List<Student> list = new ArrayList<>();
		Student student = new Student();
		student.setId(2);
		student.setName("Mrunal");
		student.setAge(40);
		student.setSalary(50000L);
		list.add(student);
		
		Mockito.when(studentService.getAll()).thenReturn(list);
			this.mockMvc.perform(get("/api/all")).andExpect(status().isOk());	
	}
	
	@Test
	public void testAddStudent() throws Exception {
		Student student = new Student("Mrunal",40,50000L);
		Mockito.when(studentService.addStudent(any(Student.class))).thenReturn(student);
		
		mockMvc.perform(post("/api/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
}