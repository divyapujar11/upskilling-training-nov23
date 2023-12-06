package com.cg.userservice.service;

import java.util.List;

import com.cg.userservice.dto.UserDto;

public interface UserService {
	
	UserDto saveUser(UserDto userdto);
	UserDto getUserById(int userId);
	List<UserDto> getAllUsers();
	List<UserDto> getAllUsersByMentorId(int mentorId);
	void deleteUserById(int userId);
	List<UserDto> getUsersByCourseId(int courseId);

}
