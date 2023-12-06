package com.cg.courseservice.service;

import java.util.List;

import com.cg.courseservice.dto.CourseDto;

public interface CourseService {
	
	CourseDto saveCourse(CourseDto courseDto);
	CourseDto getCourseById(int courseId);
	List<CourseDto> getAllCourses();
	CourseDto updateCourse(CourseDto courseDto);
	void deleteCourseById(int courseId);
	CourseDto getCourseByUserId(int userId);

}
