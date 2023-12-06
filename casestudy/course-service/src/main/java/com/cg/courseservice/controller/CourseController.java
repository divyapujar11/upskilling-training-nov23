package com.cg.courseservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.courseservice.dto.CourseDto;
import com.cg.courseservice.service.CourseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/courses")
@AllArgsConstructor
public class CourseController {
	
	private CourseService courseService;
	
	@PostMapping("/save")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }

    @GetMapping("/{courseId}")
    public CourseDto getCourseById(@PathVariable int courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/all")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping("/update")
    public CourseDto updateCourse(@RequestBody CourseDto courseDto) {
        return courseService.updateCourse(courseDto);
    }

    @DeleteMapping("/delete/{courseId}")
    public void deleteCourseById(@PathVariable int courseId) {
        courseService.deleteCourseById(courseId);
    }

    @GetMapping("/byUser/{userId}")
    public CourseDto getCourseByUserId(@PathVariable int userId) {
        return courseService.getCourseByUserId(userId);
    }
	
}
