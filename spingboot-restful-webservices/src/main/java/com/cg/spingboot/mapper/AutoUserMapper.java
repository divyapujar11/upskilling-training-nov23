package com.cg.spingboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cg.spingboot.dto.UserDto;
import com.cg.spingboot.entity.User;

@Mapper
public interface AutoUserMapper {

	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	UserDto maptoUserDto(User user);
	
	User maptoUser(UserDto userDto);
	
}
