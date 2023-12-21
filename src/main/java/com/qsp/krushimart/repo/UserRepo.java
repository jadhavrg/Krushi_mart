package com.qsp.krushimart.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.qsp.krushimart.dto.User;

public interface UserRepo extends JpaRepositoryImplementation<User, Integer>
{
	User findUserByEmail(String email) ; 
	
	@Query("select u from User u where u.email=?1 and password=?2 ")
	User findUserByEmailandPassword(String email, String password) ;
		
}
