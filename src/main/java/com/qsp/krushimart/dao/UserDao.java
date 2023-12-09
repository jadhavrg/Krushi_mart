package com.qsp.krushimart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.krushimart.dto.User;
import com.qsp.krushimart.repo.UserRepo;

@Repository
public class UserDao 
{
	@Autowired
	private UserRepo repo ;
	
	public User saveUser(User user)
	{
		return repo.save(user) ;
	}
	
	public User getUser(int id) 
	{
		Optional<User> optional = repo.findById(id) ;
		if (optional != null) 
		{
			return optional.get() ;
		}
		return null ;
	}
	
	public List<User> getAllUser() 
	{
		return repo.findAll() ;
	}
	
	public User deleteUser(int id) 
	{
		Optional<User> optional = repo.findById(id) ;
		if (optional.isPresent())
		{
			repo.deleteById(id);
			return optional.get() ;
		}
		return null ;
	}
	
	public User updateUser(int id, User user) 
	{
		Optional<User> optional = repo.findById(id) ;
		if (optional.isEmpty())
		{
			return null ;
		}
		user.setId(id);
		return repo.save(user) ;
	}
}
