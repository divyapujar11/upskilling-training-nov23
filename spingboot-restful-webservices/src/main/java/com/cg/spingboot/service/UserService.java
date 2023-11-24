package com.cg.spingboot.service;

import java.util.List;

import com.cg.spingboot.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}

