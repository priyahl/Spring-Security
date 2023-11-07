package com.diksha.springsecurity.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diksha.springsecurity.SpringSecurity.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
