package com.diksha.springsecurity.SpringSecurity.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.diksha.springsecurity.SpringSecurity.entity.User;
import com.diksha.springsecurity.SpringSecurity.repo.UserRepo;


@Component
public class UserConfService implements UserDetailsService {

	@Autowired UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username){
		User user = userRepo.findByUsername(username);
		if (user != null) {
			return new UserDetail(user);
		}else {
			throw new UsernameNotFoundException("username not found: "+username);
		}
	}

}
