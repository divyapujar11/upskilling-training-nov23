package com.cg.userservice.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.cg.userservice.dto.UserDto;
import com.cg.userservice.entity.User;
import com.cg.userservice.repository.UserRepository;
import com.cg.userservice.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;
	

	@Override
	public UserDto saveUser(UserDto userdto) {
		User user = modelMapper.map(userdto, User.class);
		User createdUser = userRepository.save(user);
		return modelMapper.map(createdUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(int userId) {
		User user =  userRepository.findById(userId).orElse(null);
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream()
				.map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAllUsersByMentorId(int mentorId) {
		// TODO Auto-generated method stub
		 List<User> users = userRepository.getAllUsersByMentorId(mentorId);
	        return users.stream()
	                .map(user -> modelMapper.map(user, UserDto.class))
	                .collect(Collectors.toList());
	}

	@Override
	public void deleteUserById(int userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
		
	}
	
	@Override
	public List<UserDto> getUsersByCourseId(int courseId) {
	    List<User> users = userRepository.getUsersByCourseId(courseId);

	    if (users != null && !users.isEmpty()) {
	        return users.stream()
	                .map(user -> modelMapper.map(user, UserDto.class))
	                .collect(Collectors.toList());
	    } else {
	        return Collections.emptyList(); // Return an empty list if no users found for the course
	    }
	}

}
