package com.diksha.springsecurity.SpringSecurity.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diksha.springsecurity.SpringSecurity.dto.UserDto;
import com.diksha.springsecurity.SpringSecurity.entity.User;
import com.diksha.springsecurity.SpringSecurity.repo.UserRepo;
import com.diksha.springsecurity.SpringSecurity.service.UserService;
@Service
public class UserServiceImpl implements UserService{
@Autowired
public UserRepo userRepo;
	@Override
	public UserDto adduser(UserDto userDto) {
		User user = new User();

		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		
		User addu = userRepo.save(user);

		userDto.setId(addu.getId());
		userDto.setUsername(addu.getUsername());
		userDto.setPassword(addu.getPassword());
		userDto.setRole(addu.getRole());

		return userDto;
	}
	@Override
	public List<UserDto> getAllUser() {
		List<User> user = userRepo.findAll();
		List<UserDto> dto = new ArrayList<>();

		for (User users : user) {
			UserDto u = new UserDto();
			u.setId(users.getId());
			u.setUsername(users.getUsername());
			u.setPassword(users.getPassword());
			u.setRole(users.getRole());

			dto.add(u);
		}
		return dto;
	}

}
