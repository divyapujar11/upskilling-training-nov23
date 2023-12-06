package com.cg.courseservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cg.courseservice.dto.CourseDto;
import com.cg.courseservice.entity.Course;
import com.cg.courseservice.repository.CourseRepository;
import com.cg.courseservice.service.CourseService;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
	
	private CourseRepository courseRepository;
	
	private ModelMapper modelMapper;

	@Override
	public CourseDto saveCourse(CourseDto courseDto) {
		Course course = modelMapper.map(courseDto, Course.class);
		Course createdCourse= courseRepository.save(course);
		return modelMapper.map(createdCourse, CourseDto.class);
	}

	@Override
	public CourseDto getCourseById(int courseId) {
		Course course =  courseRepository.findById(courseId).orElse(null);
		CourseDto courseDto = modelMapper.map(course, CourseDto.class);
		return courseDto;
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
		return courses.stream()
				.map(course -> modelMapper.map(course, CourseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CourseDto updateCourse(CourseDto courseDto) {
		Course course = modelMapper.map(courseDto, Course.class);
		Course createdCourse= courseRepository.save(course);
		return modelMapper.map(createdCourse, CourseDto.class);
	}

	@Override
	public void deleteCourseById(int courseId) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(courseId);

	}

	@Override
	public CourseDto getCourseByUserId(int userId) {
		Course course = courseRepository.getCourseByUserId(userId);
		if (course != null) {
		    return modelMapper.map(course, CourseDto.class);
		} else {
		    return new CourseDto(); // Or return null, or return some default CourseDto
		}

	}

}
