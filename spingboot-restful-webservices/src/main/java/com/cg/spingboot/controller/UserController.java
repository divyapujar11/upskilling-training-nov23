package com.cg.spingboot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.cg.spingboot.dto.UserDto;
import com.cg.spingboot.exception.ErrorDetails;
import com.cg.spingboot.exception.ResourceNotFoundException;
import com.cg.spingboot.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(
		name = "CRUD REST API for User Resource",
		description = "CRUD REST API - Create User, UpdateUser, Get User, Get All User, Delete User"
		)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @Operation(
    		summary = "Create User REST API",
    		description = "Create User API is used to save user in an database"
    		)
    @ApiResponse(
    		responseCode = "201",
    		description = "HTTP Status 201 CREATED"
    		)
    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
    		summary = "Get User By ID REST API",
    		description = "Get User By ID REST API is used to get a single user from the database"
    		)
    @ApiResponse(
    		responseCode = "200",
    		description = "HTTP Status 200 SUCCESS"
    		)
    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
    		summary = "Get All User REST API",
    		description = "Get All User REST API is used to get a all users from the database"
    		)
    @ApiResponse(
    		responseCode = "200",
    		description = "HTTP Status 200 SUCCESS"
    		)
    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
    		summary = "Update User REST API",
    		description = "Update User REST API is used to update a particular user in the database"
    		)
    @ApiResponse(
    		responseCode = "200",
    		description = "HTTP Status 200 SUCCESS"
    		)
    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody @Valid UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
    		summary = "Delete User REST API",
    		description = "Delete User REST API is used to delete a particular user from database"
    		)
    @ApiResponse(
    		responseCode = "200",
    		description = "HTTP Status 200 SUCCESS"
    		)
    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
    
    
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
//    	ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false),"USER_NOTFOUND");
//    	return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
}
