package com.qsp.krushimart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.krushimart.dao.UserDao;
import com.qsp.krushimart.dto.User;
import com.qsp.krushimart.util.ResponseStructure;

@Service
public class UserService 
{
	@Autowired
	private UserDao dao ;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		structure.setMessage("Account is created..!");
		structure.setId(HttpStatus.CREATED.value());
		structure.setData(dao.saveUser(user));
		
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED) ;
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
