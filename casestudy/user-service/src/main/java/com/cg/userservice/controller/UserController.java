package com.cg.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.userservice.dto.UserDto;
import com.cg.userservice.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	@PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/byMentor/{mentorId}")
    public List<UserDto> getAllUsersByMentorId(@PathVariable int mentorId) {
    	LOGGER.info(String.format("Received message"));
        return userService.getAllUsersByMentorId(mentorId);
    }
    
    @GetMapping("/byCourse/{courseId}")
    public List<UserDto> getUsersByCourseId(@PathVariable int courseId){
    	LOGGER.info(String.format("Received message"));
    	return userService.getUsersByCourseId(courseId);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUserById(@PathVariable int userId) {
        userService.deleteUserById(userId);
    }

}
