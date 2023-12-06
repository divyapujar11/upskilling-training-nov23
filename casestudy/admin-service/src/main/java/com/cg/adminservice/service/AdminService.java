package com.cg.adminservice.service;

import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

import com.cg.adminservice.dto.AdminDto;
import com.cg.adminservice.dto.CourseDto;
import com.cg.adminservice.dto.MentorDto;
import com.cg.adminservice.dto.UserDto;

public interface AdminService {

	AdminDto saveAdmin(AdminDto admin);

	void deletAdmin(int id);

	List<MentorDto> getAllMentors();

	List<UserDto> getAllUsersByMentorId(int mentorId);

	CourseDto getCourseByUserId(int userId);

	List<UserDto> getAllUsersByCourseId(int courseId);

	ResponseEntity<byte[]> downloadMentorsReport();

	ResponseEntity<MentorDto> saveMentorByWebClient(MentorDto mentorDto);

}
