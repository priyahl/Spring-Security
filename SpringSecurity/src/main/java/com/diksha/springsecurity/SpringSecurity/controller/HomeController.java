package com.diksha.springsecurity.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diksha.springsecurity.SpringSecurity.dto.UserDto;
import com.diksha.springsecurity.SpringSecurity.entity.User;
import com.diksha.springsecurity.SpringSecurity.service.UserService;

@RestController
public class HomeController {

//	@GetMapping("/home")
//	public String home() {
//		return "This is Home Page";
//	}
//
//	@GetMapping("/admin")
//	public String admin() {
//		return "This is Admin Page";
//	}
@Autowired
public UserService userService;
// http://localhost:8019/adduser
    @PostMapping("/adduser")
	public UserDto adduser(@RequestBody UserDto userDto) {
		return userService.adduser(userDto);
	}
 // http://localhost:8019/getAllUser
    @GetMapping("/getAllUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<UserDto> getAllUser(){
		return userService.getAllUser();
	}
 
}
