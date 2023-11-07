package com.diksha.springsecurity.SpringSecurity.service;

import java.util.List;

import com.diksha.springsecurity.SpringSecurity.dto.UserDto;

public interface UserService {
	public UserDto adduser(UserDto userDto);
	public List<UserDto>  getAllUser();

}
