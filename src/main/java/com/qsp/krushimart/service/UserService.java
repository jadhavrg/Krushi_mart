package com.qsp.krushimart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.krushimart.dao.UserDao;
import com.qsp.krushimart.dto.User;

@Service
public class UserService 
{
	@Autowired
	private UserDao dao ;
	
	public User saveUser(User user)
	{
		return dao.saveUser(user) ;
	}
	
	public User getUser(int id)
	{
		return dao.getUser(id) ;
	}
	
	public List<User> getAllUser()
	{
		return dao.getAllUser() ;
	}
	
	public User deleteUser(int id) 
	{
		return dao.deleteUser(id) ;
	}
	
	public User updateUser(int id, User user)
	{
		return dao.updateUser(id,user) ;
	}
}
