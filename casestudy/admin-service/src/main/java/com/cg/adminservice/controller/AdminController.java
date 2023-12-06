package com.cg.adminservice.controller;

import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.adminservice.dto.AdminDto;
import com.cg.adminservice.dto.CourseDto;
import com.cg.adminservice.dto.MentorDto;
import com.cg.adminservice.dto.UserDto;
import com.cg.adminservice.service.AdminService;

import lombok.AllArgsConstructor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/admin")
@AllArgsConstructor
public class AdminController {
	private AdminService adminService;
	
	 @PostMapping("/save")
	    public AdminDto saveAdmin(@RequestBody AdminDto adminDto) {
	        return adminService.saveAdmin(adminDto);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteAdmin(@PathVariable int id) {
	        adminService.deletAdmin(id);
	    }

	    // displaying all mentors
	    @GetMapping("/mentors")
	    public List<MentorDto> getAllMentors() {
	        return adminService.getAllMentors();
	    }
	    
	    // save mentor details
	    @PostMapping("/mentor/save")
	    public ResponseEntity<MentorDto> saveMentor(@RequestBody MentorDto mentorDto) {
	        return adminService.saveMentorByWebClient(mentorDto);
	    }

	    
	   // display all users by mentorId
	    @GetMapping("/users/{mentorId}")
	    public List<UserDto> getAllUsersByMentorId(@PathVariable int mentorId) {
	        return adminService.getAllUsersByMentorId(mentorId);
	    }
	    
	   // display all users by courseId
	    @GetMapping("/get/users/{courseId}")
	    public List<UserDto> getUsersByCourseId(@PathVariable int courseId){
	    	return adminService.getAllUsersByCourseId(courseId);
	    }

	    // display all courses by userId
	    @GetMapping("/courses/{userId}")
	    public CourseDto getCourseByUserId(@PathVariable int userId) {
	        return adminService.getCourseByUserId(userId);
	    }
	    
	    
	    @GetMapping("/downloadMentorsReport")
	    public ResponseEntity<byte[]> downloadMentorsReport() {
	        return adminService.downloadMentorsReport();
	    }
}
