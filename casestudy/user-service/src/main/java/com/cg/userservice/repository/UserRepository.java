package com.cg.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.userservice.dto.UserDto;
import com.cg.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> getAllUsersByMentorId(int mentorId);

	List<User> getUsersByCourseId(int courseId);

}
