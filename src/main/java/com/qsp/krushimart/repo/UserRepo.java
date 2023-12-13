package com.qsp.krushimart.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.qsp.krushimart.dto.User;

public interface UserRepo extends JpaRepositoryImplementation<User, Integer>
{
	User findUserByEmail(String email) ; 
	

		
}
